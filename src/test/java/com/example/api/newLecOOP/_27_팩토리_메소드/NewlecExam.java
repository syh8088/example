package com.example.api.newLecOOP._27_팩토리_메소드;

public class NewlecExam extends Exam {

    private int com;

    public NewlecExam() {
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
        return onTotal() + com;
    }

    @Override
    public float avg() {
        return this.total() / 3.0f;
    }
}
