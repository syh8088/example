package com.example.api.service;

import com.example.api.controller.AppNoticeController;
import com.example.api.entities.appnotice.AppNotice;
import com.example.api.entities.appnotice.AppNoticeDevice;
import com.example.api.repositories.appnotice.AppNoticeMapper;
import com.example.api.repositories.appnotice.AppNoticeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class AppNoticeService {

    private AppNoticeMapper appNoticeMapper;
    private AppNoticeRepository appNoticeRepository;
    private List<String> noticeName = Arrays.asList("mobile_web", "sport_android", "sport_ios", "game_android", "game_ios");

    @Autowired
    public AppNoticeService(AppNoticeMapper appNoticeMapper, AppNoticeRepository appNoticeRepository) {
        this.appNoticeMapper = appNoticeMapper;
        this.appNoticeRepository = appNoticeRepository;
    }

    public List<AppNotice> getAppNoticeList() {
        List<AppNotice> appNoticeList = appNoticeMapper.getAppNoticeList(noticeName);
        return appNoticeList;
    }

    public AppNotice getAppNotice(long id) {
        AppNotice appNotice = appNoticeRepository.findById(id);
        return appNotice;
    }

    @Transactional
    public void updateAppNotice(AppNoticeController.CreatePostRequest request) {

        AppNotice originAppNotice = appNoticeRepository.findById(request.getId());

        AppNotice newAppNotice = new AppNotice();
        newAppNotice.setReserveAt(request.reserve_at);
        newAppNotice.setContent(request.content);
        newAppNotice.setTitle(request.title);
        newAppNotice.setCategory(AppNotice.Category.valueOf(request.category.toUpperCase()));
        newAppNotice.setId(request.getId());

        BeanUtils.copyProperties(newAppNotice, originAppNotice);

    }

    public AppNotice setAppNotice(AppNoticeController.CreatePostRequest request) {
        //System.out.println(AppNotice.Category.valueOf(request.category.toUpperCase()).getClass());
        //System.out.println(request.category.toUpperCase().getClass());

        AppNotice appNotice = new AppNotice();

        appNotice.setCategory(AppNotice.Category.valueOf(request.category.toUpperCase()));
        appNotice.setTitle(request.title);
        appNotice.setContent(request.content);
        appNotice.setReserveAt(request.reserve_at);

        appNoticeMapper.setAppNotice(appNotice);
        long insertId = appNotice.getId();

        List<AppNoticeDevice> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();

        if(request.MOBILE_WEB) {
            AppNoticeDevice appNoticeDevice = setAppNoticeDeviceArray("MOBILE_WEB", insertId, request);
            list.add(appNoticeDevice);
        }

        if(request.SPORT_ANDROID) {
            AppNoticeDevice appNoticeDevice = setAppNoticeDeviceArray("SPORT_ANDROID", insertId, request);
            list.add(appNoticeDevice);
        }

        if(request.SPORT_IOS) {
            AppNoticeDevice appNoticeDevice = setAppNoticeDeviceArray("SPORT_IOS", insertId, request);
            list.add(appNoticeDevice);
        }

        if(request.GAME_ANDROID) {
            AppNoticeDevice appNoticeDevice = setAppNoticeDeviceArray("GAME_ANDROID", insertId, request);
            list.add(appNoticeDevice);
        }

        if(request.GAME_IOS) {
            AppNoticeDevice appNoticeDevice = setAppNoticeDeviceArray("GAME_IOS", insertId, request);
            list.add(appNoticeDevice);
        }

        map1.put("list", list);
        appNoticeMapper.setAppNoticeDevice(map1);
        AppNotice newAppNotice = getAppNotice(insertId);
        return newAppNotice;


/*
        Map<String, Boolean> params = new HashMap<>();
        params.put("MOBILE_WEB", request.MOBILE_WEB);
        params.put("SPORT_ANDROID", request.SPORT_ANDROID);
        params.put("SPORT_IOS", request.SPORT_IOS);
        params.put("GAME_ANDROID", request.GAME_ANDROID);
        params.put("GAME_IOS", request.GAME_IOS);

        for(int i=0; i<noticeName.size(); i++) {
            String val = noticeName.get(i);

            }

            if (params.get(val.toUpperCase())) {

                System.out.println("여기오니?? " + val);
                AppNoticeDevice appNoticeDevice = new AppNoticeDevice();
                new AppNoticeDevice().
            }
        }*/


    }
    private AppNoticeDevice setAppNoticeDeviceArray(String mode, long insertId, AppNoticeController.CreatePostRequest request) {
        String type = mode.toLowerCase();
        AppNoticeDevice appNoticeDevice = new AppNoticeDevice();
        appNoticeDevice.setNoticeId(insertId);
        appNoticeDevice.setType(AppNoticeDevice.Type.valueOf(mode));
        //if(request.mobile_web_notice_top_allowed == "Y") {

        switch (type) {
            case "mobile_web":
                appNoticeDevice.setNoticeTopAllowed(request.mobile_web_notice_top_allowed.equals("Y"));
//                if(request.mobile_web_notice_top_allowed.equals("Y")) {
//                    appNoticeDevice.setNoticeTopAllowed(true);
//                } else {
//                    appNoticeDevice.setNoticeTopAllowed(false);
//                }

                if(request.mobile_web_popup_allowed.equals("Y")) {
                    appNoticeDevice.setPopupAllowed(true);
                } else {
                    appNoticeDevice.setPopupAllowed(false);
                }
                break;
            case "sport_android":
                if(request.sport_android_notice_top_allowed.equals("Y")) {
                    appNoticeDevice.setNoticeTopAllowed(true);
                } else {
                    appNoticeDevice.setNoticeTopAllowed(false);
                }

                if(request.sport_android_popup_allowed.equals("Y")) {
                    appNoticeDevice.setPopupAllowed(true);
                } else {
                    appNoticeDevice.setPopupAllowed(false);
                }
                break;
            case "sport_ios":
                if(request.sport_ios_notice_top_allowed.equals("Y")) {
                    appNoticeDevice.setNoticeTopAllowed(true);
                } else {
                    appNoticeDevice.setNoticeTopAllowed(false);
                }

                if(request.sport_ios_popup_allowed.equals("Y")) {
                    appNoticeDevice.setPopupAllowed(true);
                } else {
                    appNoticeDevice.setPopupAllowed(false);
                }
                break;
            case "game_android":
                if(request.game_android_notice_top_allowed == "Y") {
                    appNoticeDevice.setNoticeTopAllowed(true);
                } else {
                    appNoticeDevice.setNoticeTopAllowed(false);
                }

                if(request.game_android_popup_allowed.equals("Y")) {
                    appNoticeDevice.setPopupAllowed(true);
                } else {
                    appNoticeDevice.setPopupAllowed(false);
                }
                break;
            case "game_ios":
                if(request.game_ios_notice_top_allowed.equals("Y")) {
                    appNoticeDevice.setNoticeTopAllowed(true);
                } else {
                    appNoticeDevice.setNoticeTopAllowed(false);
                }

                if(request.game_ios_popup_allowed.equals("Y")) {
                    appNoticeDevice.setPopupAllowed(true);
                } else {
                    appNoticeDevice.setPopupAllowed(false);
                }
                break;
        }


        return appNoticeDevice;
    }

}
