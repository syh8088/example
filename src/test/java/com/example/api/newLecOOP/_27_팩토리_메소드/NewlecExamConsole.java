package com.example.api.newLecOOP._27_팩토리_메소드;

public class NewlecExamConsole extends ExamConsole {

    @Override
    protected Exam makeExam() {
        return new NewlecExam();
    }
}
