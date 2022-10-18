package com.ecommerceback;

import com.ecommerceback.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EcommerceBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceBackApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public WebConfig getWebConfig() { return new WebConfig(); }
}
