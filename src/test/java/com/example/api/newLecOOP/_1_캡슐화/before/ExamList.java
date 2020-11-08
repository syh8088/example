package com.example.api.newLecOOP._1_캡슐화.before;

import org.apache.ibatis.type.Alias;

@Alias("Test2ExamList")
public class ExamList {
    Exam[] exams;
    int current;
}
