package com.example.demo2.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/7/31 9:49
 */
@Configuration
public class CacheConfig {
    @Bean(name = "cache")
    public Cache<String, Object> cache() {
        Cache<String, Object> cache = Caffeine.newBuilder()
                .maximumSize(100)
                .expireAfterAccess(2, TimeUnit.HOURS)
                .build();
        return cache;
    }
}
