package com.insideme.insidemebackend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:OpenAI.properties")
public class OpenAIConfig {
    @Value("${openai.api.key}")
    private String ApiKey;
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Content-Type", "application/json");
            request.getHeaders().add("Authorization", "Bearer " + ApiKey);
            request.getHeaders().add("OpenAI-Beta", "assistants=v2");
            return execution.execute(request, body);
        });
        return restTemplate;
    }
}