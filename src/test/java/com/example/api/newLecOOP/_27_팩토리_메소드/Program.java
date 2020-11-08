package com.example.api.newLecOOP._27_팩토리_메소드;

import org.apache.ibatis.type.Alias;

@Alias("ver27Program")
public class Program {

    public static void main(String[] args) {
        ExamConsole console = new NewlecExamConsole();
        console.input();
        console.print();
    }
}
