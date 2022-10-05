package com.ajisegiri.paystack.config;


import com.ajisegiri.paystack.wehooks.PaystackIpWhitelisting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Interceptor {

    @Configuration
    public class WebMvcConfig implements WebMvcConfigurer {

        @Autowired
        private PaystackIpWhitelisting interceptor;

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(interceptor).addPathPatterns("/api/paystack/events");
        }
    }
}
