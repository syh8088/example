package com.example.api;

import com.example.api.entities.appnotice.AppNotice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ExampleApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void enumTest() {
        //System.out.println(AppNotice.Category.EVENT.name());
        //System.out.println(AppNotice.Category.valueOf("EVENT"));

        List<Integer> list = Arrays.asList(1, 2, 3);
        List<String> noticeName = Arrays.asList("mobile_web", "sport_android", "sport_ios", "game_android", "game_ios");

        noticeName.forEach(e -> {
            //System.out.println(e);
        });


        IntStream.range(0, 5).forEach(i -> {
        });

        list.forEach(i -> {
           // System.out.println(i);
           /*
            IntStream.range(0, i).forEach(j -> {
                //System.out.println(i);
                //System.out.println(j);
            });*/
        });



        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        list1.stream().forEach((i) -> {
            System.out.println(i);
        });


    }

}
