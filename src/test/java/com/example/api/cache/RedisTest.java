package com.example.api.cache;

import com.example.api.ExampleApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExampleApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testDataHandling() throws Exception {

        String key = "key:springboot";
        redisTemplate.opsForValue().set(key, "Helloz");
        String value = (String)redisTemplate.opsForValue().get(key);

        Assert.assertEquals("Hello", value);
    }


}
