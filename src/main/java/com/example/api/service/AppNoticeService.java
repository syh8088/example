package com.example.api.service;

import com.example.api.entities.appnotice.AppNotice;
import com.example.api.entities.appnotice.SubSelectArray;
import com.example.api.repositories.AppNoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppNoticeService {

    private AppNoticeMapper appNoticeMapper;
    //private static SubSelectArray subSelectArray;
    private static Map<String, String> subSelectArray = new HashMap<String, String>();

    static {
        /*subSelectArray = new SubSelectArray();
        subSelectArray.setMobileWeb("mobile_web");
        subSelectArray.setSportAndroid("sport_android");
        subSelectArray.setGameAndroid("sport_ios");
        subSelectArray.setGameAndroid("game_android");
        subSelectArray.setGameIos("game_ios");*/


        subSelectArray.put("모바일 웹", "mobile_web");
        subSelectArray.put("스포츠 Android", "sport_android");
        subSelectArray.put("스포츠 iOS", "sport_ios");
        subSelectArray.put("오락실 Android", "game_android");
        subSelectArray.put("오락실 iOS", "game_ios");
    }

    @Autowired
    public AppNoticeService(AppNoticeMapper appNoticeMapper) {
        this.appNoticeMapper = appNoticeMapper;
    }

    public AppNotice getAppNoticeList() {
        System.out.println(subSelectArray);

        //AppNotice appNotice = new AppNotice();
        //appNotice.setSubSelectArray((List) subSelectArray);


        AppNotice appNoticeList = appNoticeMapper.getAppNoticeList(subSelectArray);
        return appNoticeList;
    }

}
