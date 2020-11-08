package com.example.api.newLecOOP._27_팩토리_메소드;

import org.apache.ibatis.type.Alias;

@Alias("ver27NewlecExamConsole")
public class NewlecExamConsole extends ExamConsole {

    @Override
    protected Exam makeExam() {
        return new NewlecExam();
    }
}
