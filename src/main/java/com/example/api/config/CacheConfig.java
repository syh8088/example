package com.example.api.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
public class CacheConfig {
    @Bean
    public CacheManager cacheManager() {
        // 로컬 캐시 & 힙 메모리 & 가비지 컬렉션과의 관계 생각해보자 (GC와 STW 관계)
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(generateCacheName());
        return cacheManager;
    }

    private List<Cache> generateCacheName() {
        Cache cache = new ConcurrentMapCache("MemberGroup");
        return Collections.singletonList(cache);
    }
}
