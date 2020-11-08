package com.example.api.newLecOOP._28_이벤트_메소드_구현하기;

import org.apache.ibatis.type.Alias;

@Alias("ver28Program")
public class Program {

    public static void main(String[] args) {
        ExamConsole console = new NewlecExamConsole();
        console.input();
        console.print();
    }
}
