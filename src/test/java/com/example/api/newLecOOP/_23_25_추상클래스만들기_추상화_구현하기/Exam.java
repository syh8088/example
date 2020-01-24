package com.example.api.newLecOOP._23_25_추상클래스만들기_추상화_구현하기;

public abstract class Exam {
    int kor;
    int eng;
    int math;

    public Exam() {
        this(0, 0, 0);
    }

    public Exam(int kor, int eng, int math) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public abstract int total();

    protected int onTotal() {
        return kor + eng + math;
    }

    public abstract float avg();
}
