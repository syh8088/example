package com.example.api.newLecOOP._28_이벤트_메소드_구현하기;

import org.apache.ibatis.type.Alias;

@Alias("ver28ExamList")
public class ExamList {
    private Exam[] exams;
    private int current;

    public Exam get(int i) {
        return this.exams[i];
    }

    public void add(Exam exam) {
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

    public int size() {
        return current;
    }
}
