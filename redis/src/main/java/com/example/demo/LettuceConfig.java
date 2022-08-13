package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class LettuceConfig {
    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("192.168.0.102", 6379);
        config.setPassword("1234");
        return new LettuceConnectionFactory(config);
    }

//    @Bean
//    public JedisConnectionFactory redisConnectionFactory() {
//
//        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("192.168.0.102", 6379);
//        config.setPassword("1234");
//        return new JedisConnectionFactory(config);
//    }
}
