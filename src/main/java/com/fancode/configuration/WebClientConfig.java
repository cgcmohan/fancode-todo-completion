package com.fancode.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	
    @Autowired
    private ApiConfig apiConfig;
    
	@Bean
	public WebClient webClient() {
		return WebClient.builder()//
				.baseUrl(apiConfig.getBaseUrl())//
				.build();
	}
}
