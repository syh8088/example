package com.example.api;

import com.example.api.annotation.InsertIntData;
import com.example.api.annotation.InsertStringData;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExampleApplication.class)
@Slf4j
public class AnnotationExamTest {

    @Test
    public void test() {

        AnnotationHandler handler = new AnnotationHandler();
        AnnotationExam01 exam01 = handler.getInstance(AnnotationExam01.class, InsertIntData.class)
                .map(o -> (AnnotationExam01)o)
                .orElse(new AnnotationExam01());

        AnnotationExam02 exam02 = handler.getInstance(AnnotationExam02.class, InsertStringData.class)
                .map(o -> (AnnotationExam02)o)
                .orElse(new AnnotationExam02());

        System.out.println("myAge = " + exam01.getMyAge());
        System.out.println("defaultAge = " + exam01.getDefaultAge());

        System.out.println("myData = " + exam02.getMyData());
        System.out.println("defaultData = " + exam02.getDefaultData());
    }

}
