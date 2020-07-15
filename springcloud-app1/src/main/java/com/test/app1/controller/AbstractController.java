package com.test.app1.controller;

//import com.chinaunicom.data.harbour.oauth.sdk.utils.Oauth2Util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author lizhixiang
 */
public abstract class AbstractController {

    protected HttpServletRequest httpServletRequest;

    protected HttpServletResponse httpServletResponse;

    protected HttpSession httpSession;

    @Autowired

    @ModelAttribute
    public void setReqAndResp(HttpServletRequest request, HttpServletResponse response) {
        this.httpServletRequest = request;
        this.httpServletResponse = response;
        this.httpSession = request.getSession();
    }

    public JSONObject getUserInfo() {
    	JSONObject claims = this.getJwtClaimsFromHeader(httpServletRequest);
        return claims;
    }

    public JSONObject getJwtClaimsFromHeader(HttpServletRequest request) {
        if (request == null) {
            return null;
        }
        //取出头信息
        String authorization = request.getHeader("user");
        JSONObject obj = JSONObject.parseObject(authorization);
        return obj;
    }
}
