package com.example.api.entities.appnotice;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;

@Entity
@Slf4j
@Data
public class SubSelectArray {
    private String mobileWeb;
    private String sportAndroid;
    private String sportIos;
    private String gameAndroid;
    private String gameIos;
}

