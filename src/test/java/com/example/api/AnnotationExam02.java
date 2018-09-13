package com.example.api;

import com.example.api.annotation.InsertStringData;

public class AnnotationExam02 {

    @InsertStringData(data = "MHLab")
    private String myData;

    @InsertStringData
    private String defaultData;

    public AnnotationExam02() {
        myData = "No data";
        defaultData = "No data";
    }

    public String getMyData() {
        return myData;
    }

    public String getDefaultData() {
        return defaultData;
    }
}