package com.xy.sczl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.xy.sczl.filters.AdminAuthenticationInterceptor;
import com.xy.sczl.filters.AuthenticationInterceptor;


/**
 * 拦截器
 */
@Configuration
public class WebConfig implements WebMvcConfigurer  {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns(
                "/user/*","/order/*","/cart/*"
        ).excludePathPatterns("/user/login","/user/reg","/user/logout");

        registry.addInterceptor(new AdminAuthenticationInterceptor()).addPathPatterns(
                "/admin/*","/*/admin/*"
        ).excludePathPatterns("/admin/login","/admin/reg","/admin/logout");
    }

    @Bean(name = "multipartResolver")
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

}
