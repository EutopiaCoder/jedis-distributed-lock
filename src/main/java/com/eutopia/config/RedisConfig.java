package com.eutopia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

@Configuration
public class RedisConfig {

    @Bean
    public JedisPool redisPoolFactory() throws Exception {
        return new JedisPool("localhost", 6379);
    }
}
