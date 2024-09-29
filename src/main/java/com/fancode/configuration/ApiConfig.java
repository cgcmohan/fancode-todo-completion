package com.fancode.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "fancode")
@Getter
@Setter
public class ApiConfig {
	private String baseUrl;
    private Endpoints endpoints;
    
    @Getter
    @Setter
    public static class Endpoints {
        private String todos;
        private String users;
    }
}
