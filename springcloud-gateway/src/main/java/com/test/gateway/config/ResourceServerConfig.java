package com.test.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * Created by Steven on 2019/10/27.
 */
@EnableWebFluxSecurity
public class ResourceServerConfig {
	
	private OAuth2ResourceServerProperties.Jwt Properties =null;

    @Autowired
    public void ResourceServerConfigurer(OAuth2ResourceServerProperties Properties) {
        this.Properties = Properties.getJwt();
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange()
                .pathMatchers("/service-auth/oauth/**").permitAll()
                .pathMatchers("/service-auth/rsa/**").permitAll()
                .anyExchange().authenticated().and().cors().disable()
                .csrf().disable();

        http.oauth2ResourceServer().jwt();

        return http.build();
    }
}