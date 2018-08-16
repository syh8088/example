package com.example.api;

import com.example.api.entities.appnotice.AppNotice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ExampleApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void enumTest() {
        System.out.println(AppNotice.Category.EVENT.name());
        System.out.println(AppNotice.Category.valueOf("EVENT"));




    }

}
