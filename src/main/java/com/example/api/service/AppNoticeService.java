package com.example.api.service;

import com.example.api.entities.appnotice.AppNotice;
import com.example.api.repositories.appnotice.AppNoticeMapper;
import com.example.api.repositories.appnotice.AppNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppNoticeService {

    private AppNoticeMapper appNoticeMapper;
    private AppNoticeRepository appNoticeRepository;
    private static Map<String, List> subSelectArray = new HashMap<String, List>();

    static {


       /* subSelectArray.put("모바일 웹", "mobile_web");
        subSelectArray.put("스포츠 Android", "sport_android");
        subSelectArray.put("스포츠 iOS", "sport_ios");
        subSelectArray.put("오락실 Android", "game_android");
        subSelectArray.put("오락실 iOS", "game_ios");*/
    }

    @Autowired
    public AppNoticeService(AppNoticeMapper appNoticeMapper, AppNoticeRepository appNoticeRepository) {
        this.appNoticeMapper = appNoticeMapper;
        this.appNoticeRepository = appNoticeRepository;
    }

    public AppNotice getAppNoticeList() {
       // System.out.println(subSelectArray);

        //AppNotice appNotice = new AppNotice();
        //appNotice.setSubSelectArray((List) subSelectArray);
/*

        SubSelectArray subSelectArray1 = new SubSelectArray();
        SubSelectArray subSelectArray2 = new SubSelectArray();
        SubSelectArray subSelectArray3 = new SubSelectArray();
        SubSelectArray subSelectArray4 = new SubSelectArray();
        SubSelectArray subSelectArray5 = new SubSelectArray();

        subSelectArray1.setSubTableName("mobile_web");
        subSelectArray2.setSubTableName("sport_android");
        subSelectArray3.setSubTableName("sport_ios");
        subSelectArray4.setSubTableName("game_android");
        subSelectArray5.setSubTableName("game_ios");*/

        List<String> list = Arrays.asList("mobile_web", "sport_android", "sport_ios", "game_android", "game_ios");
       /* list.add(subSelectArray1);
        list.add(subSelectArray2);
        list.add(subSelectArray3);
        list.add(subSelectArray4);
        list.add(subSelectArray5);*/

       // subSelectArray.put("list", list);

//System.out.println(subSelectArray);

        AppNotice appNoticeList = appNoticeMapper.getAppNoticeList(list);
        return appNoticeList;
    }

    public AppNotice getAppNotice(long id) {
        AppNotice appNotice = appNoticeRepository.findById(id);

        System.out.println(appNotice);
        return appNotice;
    }

}
