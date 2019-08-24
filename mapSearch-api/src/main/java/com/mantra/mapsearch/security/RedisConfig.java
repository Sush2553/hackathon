package com.mantra.mapsearch.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {
    @Value("${spring.redis.host}")
    private String REDIS_HOSTNAME;

    @Value("${spring.redis.port}")
    private int REDIS_PORT;

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
        jedisConFactory.setHostName(REDIS_HOSTNAME);
        jedisConFactory.setPort(REDIS_PORT);
        return jedisConFactory;
    }
    @Bean
    public RedisTemplate<String,String> redisTemplate() {
        final RedisTemplate<String,String> template = new RedisTemplate<String,String>();
        template.setConnectionFactory(jedisConnectionFactory());
        // template.setValueSerializer(new GenericToStringSerializer<User>(User.class));
        return template;
    }

}
