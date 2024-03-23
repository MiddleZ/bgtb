package com.bgtb01.bgtb.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchClientConnect {
    @Value("${elasticsearch.port}")
    private int port;

    @Value("${elasticsearch.ip}")
    private String ip;

//    @Value("${elasticsearch.username}")
//    private String username;
//
//    @Value("${elasticsearch.password}")
//    private String password;

    /**
     * 创建rest客户端
     */

}
