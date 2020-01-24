package com.example.api.newLecOOP._15_16_17_Exam을_IS_A_상속하기;

import com.example.api.newLecOOP._10_UI코드분리하기.Exam;

public class NewlecExam extends Exam {

    private int com;

    public NewlecExam(int com) {
        this(0, 0, 0, 0);
    }

    public NewlecExam(int kor, int eng, int math, int com) {
        super(kor, eng, math);
        this.com = com;
    }

    public int getCom() {
        return com;
    }

    public void setCom(int com) {
        this.com = com;
    }

    @Override
    public int total() {
        return super.total() + com;
    }

    @Override
    public float avg() {
        return total() / 4.0f;
    }
}
