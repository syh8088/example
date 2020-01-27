package com.example.api.newLecOOP._8_Getters와Setters;

import java.util.Scanner;

public class ExamList {
    Exam[] exams;
    int current;

    void printList() {
        this.printList(this.current);
    }

    void printList(int size) {
        System.out.println("┌──────────────────────────┐");
        System.out.println("│        성적 출력              │");
        System.out.println("└──────────────────────────┘");

        Exam[] exams = this.exams;

        for (int i= 0; i < size; i++) {
            Exam exam = exams[i];
            //int kor = exam.kor;
            int kor = exam.getKor();
            //int eng = exam.eng;
            int eng = exam.getEng();
            //int math = exam.math;
            int math = exam.getMath();

            //int total = kor + eng + math;
            int total = exam.total();
            //float avg = total / 3.0f;
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

        //Exam exam = new Exam();
        Exam exam = new Exam(kor, eng, math);


      /*  //exam.kor = kor;
        exam.setEng(kor);
        //exam.eng = eng;
        exam.setEng(eng);
        //exam.math = math;
        exam.setMath(math);*/


        Exam[] exams = this.exams;
        int size = this.current;

        if(exams.length == size) {
            // 1. 크기가 5개 정도 더 큰 새로운 배열을 생성하시오
            Exam[] temp = new Exam[size + 5];
            // 2. 값을 이주시키기
            for(int i = 0; i < size; i++)
                temp[i] = exams[i];
            // 3. list.exams가 새로만든 temp 배열을 참조하도록
            this.exams = temp;
        }

        this.exams[this.current] = exam;
        this.current++;

    }

    public ExamList() {
        this(3);
    }

    public ExamList(int size) {
        exams = new Exam[size];
        current = 0;
    }
}
