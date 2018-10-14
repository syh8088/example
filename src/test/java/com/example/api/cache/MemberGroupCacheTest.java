package com.example.api.cache;

import com.example.api.ExampleApplication;
import com.example.api.service.member.MemberGroupService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExampleApplication.class)
public class MemberGroupCacheTest {

    @Autowired
    MemberGroupService memberGroupService;

    @Test
    public void getMemberGroup() {

        long h2Start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            memberGroupService.getMemberGroupViewModel(1);
        }
        long h2End = System.currentTimeMillis();

        long cacheStart = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            memberGroupService.getMemberGroupViewModelByCache(1);
        }
        long cacheEnd = System.currentTimeMillis();

        System.out.println("H2 걸린시간 :" + (h2End - h2Start));
        System.out.println("Cache 걸린시간 :" + (cacheEnd - cacheStart));
    }

}
