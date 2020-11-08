package com.example.api.newLecOOP._23_25_추상클래스만들기_추상화_구현하기;

import org.apache.ibatis.type.Alias;

import java.util.Scanner;

@Alias("ver23ExamConsole")
public class ExamConsole {

    // Composition Has A 일체형
    private ExamList list = new ExamList();

    void printList() {
        this.printList(list.size());
    }

    void printList(int size) {
        System.out.println("┌──────────────────────────┐");
        System.out.println("│        성적 출력              │");
        System.out.println("└──────────────────────────┘");

        //Exam[] exams = this.exams;

        for (int i= 0; i < size; i++) {
            //Exam exam = exams[i];
            //Exam exam = this.exams[i];
            Exam exam = list.get(i);

            int kor = exam.getKor();
            int eng = exam.getEng();
            int math = exam.getMath();

            int total = exam.total();
            float avg = exam.avg();

            System.out.printf("국어 : %d\n", kor);
            System.out.printf("영어 : %d\n", eng);
            System.out.printf("수학 : %d\n", math);

            System.out.printf("총점 : %3d\n", total);
            System.out.printf("평균 : %6.2f\n", avg);
        }
    }

    void inputList() {
        Scanner scan = new Scanner(System.in);
        System.out.println("┌──────────────────────────┐");
        System.out.println("│        성적 입력              │");
        System.out.println("└──────────────────────────┘");

        int kor, eng, math;

        do {
            System.out.printf("국어 : ");
            kor = scan.nextInt();

            if (kor < 0 || 100 < kor)
                System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");

        } while (kor < 0 || 100 < kor);

        do {
            System.out.printf("영어 : ");
            eng = scan.nextInt();

            if (eng < 0 || 100 < eng)
                System.out.println("영어성적은 0~100까지의 범위만 입력이 가능합니다.");

        } while (eng < 0 || 100 < eng);

        do {
            System.out.printf("수학 : ");
            math = scan.nextInt();

            if (math < 0 || 100 < math)
                System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");

        } while (math < 0 || 100 < math);

        // 팩토리 메소드 구현에서 해결하자
       //  Exam exam = new Exam(kor, eng, math);
       // list.add(exam);

    }
}
