package com.example.api.newLecOOP._15_16_17_Exam을_IS_A_상속하기;

import org.apache.ibatis.type.Alias;

@Alias("ver15Program")
public class Program {

    public static void main(String[] args) {
        NewlecExam exam = new NewlecExam(10, 10, 10, 10);
        /*exam.setKor(10);
        exam.setEng(10);
        exam.setMath(10);
        exam.setCom(10);*/

        System.out.println(exam.total());
        System.out.println(exam.avg());
    }
}
