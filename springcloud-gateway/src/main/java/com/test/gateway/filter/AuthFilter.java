package com.test.gateway.filter;

import com.test.gateway.config.*;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.oauth2.sdk.ParseException;

import org.bouncycastle.jcajce.provider.asymmetric.rsa.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RefreshScope
public class AuthFilter implements GlobalFilter, Ordered {
	@Autowired
	private IgnoreUrlAuthConfig urlAuthConfig;

	private static String SINGING_KEY = "uaa123";

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		String token = exchange.getRequest().getHeaders().getFirst("Authorization");
		ServerHttpResponse response = exchange.getResponse();
		String path = exchange.getRequest().getURI().getPath();
		// 不需要权限配置的放行
		if (urlAuthConfig.getUrls() != null) {
			for (String url : urlAuthConfig.getUrls()) {
				if (path.contains(url)) {
					return chain.filter(exchange);
				}
			}
		}
		if (com.nimbusds.oauth2.sdk.util.StringUtils.isBlank(token)) {
			// 封装错误信息
			Map<String, Object> responseData = new HashMap<String, Object>();
			responseData.put("code", 401);
			responseData.put("message", "非法请求");
			responseData.put("cause", "Token is empty");
			try {
				return rtnErrorMsg(response, responseData);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		} else {
			// 从token中解析用户信息并设置到Header中去
			String realToken = token.replace("Bearer ", "").replace("bearer ", "");
			JWSObject jwsObject;
			try {
				jwsObject = JWSObject.parse(realToken);
				String userStr = jwsObject.getPayload().toString();
				JSONObject userJson = JSONObject.parseObject(userStr);
				@SuppressWarnings("unchecked")
				List<String> authoritiesList = (List<String>) userJson.get("authorities");
				for (int i = 0; i < authoritiesList.size(); i++) {
					if (path.contains(authoritiesList.get(i))) {
						System.out.println(userStr);
						ServerHttpRequest request = exchange.getRequest().mutate().header("user", userStr).build();
						exchange = exchange.mutate().request(request).build();
						return chain.filter(exchange);
					}
				}
				// 封装错误信息
				Map<String, Object> responseData = new HashMap<String, Object>();
				responseData.put("code", 403);
				responseData.put("message", "没有权限");
				responseData.put("cause", "authorities is err");
				try {
					return rtnErrorMsg(response, responseData);
				} catch (JsonProcessingException e1) {
					e1.printStackTrace();
				}
			} catch (java.text.ParseException e) {
				// 封装错误信息
				Map<String, Object> responseData = new HashMap<String, Object>();
				responseData.put("code", 402);
				responseData.put("message", "解析失败");
				responseData.put("cause", "Token is err");
				try {
					return rtnErrorMsg(response, responseData);
				} catch (JsonProcessingException e1) {
					e1.printStackTrace();
				}
			}
		}
		return chain.filter(exchange);
	}

	private Mono<Void> rtnErrorMsg(ServerHttpResponse response, Map<String, Object> responseData)
			throws JsonProcessingException {
		// 将信息转换为 JSON
		ObjectMapper objectMapper = new ObjectMapper();
		byte[] data = objectMapper.writeValueAsBytes(responseData);

		// 输出错误信息到页面
		DataBuffer buffer = response.bufferFactory().wrap(data);
		response.setStatusCode(HttpStatus.UNAUTHORIZED);
		response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
		return response.writeWith(Mono.just(buffer));
	}

	/**
	 * 设置过滤器的执行顺序
	 *
	 * @return
	 */
	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}

	/**
	 * 返回校验失败
	 *
	 * @param exchange
	 * @return
	 */
	private Mono<Void> returnAuthFail(ServerWebExchange exchange, String message) {
		ServerHttpResponse serverHttpResponse = exchange.getResponse();
		serverHttpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
		String resultData = "{\"status\":\"-1\",\"msg\":" + message + "}";
		byte[] bytes = resultData.getBytes(StandardCharsets.UTF_8);
		DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
		return exchange.getResponse().writeWith(Flux.just(buffer));
	}

}