package com.example.api.newLecOOP._28_이벤트_메소드_구현하기;

import org.apache.ibatis.type.Alias;

import java.util.Scanner;

@Alias("ver28NewlecExamConsole")
public class NewlecExamConsole extends ExamConsole {

    @Override
    protected Exam makeExam() {
        return new NewlecExam();
    }

    @Override
    protected void onPrint(Exam exam) {
        NewlecExam newlecExam = (NewlecExam) exam;
        int com = newlecExam.getCom();
        System.out.printf("컴퓨터 : %d\n", com);
    }

    @Override
    protected void onInput(Exam exam) {
        NewlecExam newlecExam = (NewlecExam) exam;

        Scanner scan = new Scanner(System.in);
        int com;

        do {
            System.out.printf("컴퓨터 : ");
            com = scan.nextInt();

            if (com < 0 || 100 < com)
                System.out.println("컴퓨터성적은 0~100까지의 범위만 입력이 가능합니다.");

        } while (com < 0 || 100 < com);

        newlecExam.setCom(com);
    }
}
