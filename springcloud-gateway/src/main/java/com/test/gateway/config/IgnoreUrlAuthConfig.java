package com.test.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ConfigurationProperties(prefix = "ignore")
public class IgnoreUrlAuthConfig {

    private List<String> urls;
}
