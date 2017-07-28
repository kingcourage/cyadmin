package com.wcy.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by huguoju on 2016/12/29.
 */
@Configuration
@Data
@PropertySource("classpath:redis.properties")
@ConfigurationProperties(prefix = "spring.redis")
public class Redis {
    private String database;
    private String host;
    private String password;
    private int port;
    private int timeout;
    private String maxIdle;
    private String minIdle;
    private String maxActive;
    private String maxWait;


}
