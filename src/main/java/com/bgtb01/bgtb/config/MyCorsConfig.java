package com.bgtb01.bgtb.config;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class MyCorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:8888");//允许跨域的域名，如果要携带cookie,不能写*，*代表所有域名都可以跨域访问
        configuration.setAllowCredentials(true);//允许携带cookie
        configuration.addAllowedMethod("*");//允许所有请求方法
        configuration.addAllowedHeader("*");//允许所有请求头
        //过滤器
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);

        return new CorsFilter(source);
    }
}












