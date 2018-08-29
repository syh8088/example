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

    //public void setAppNotice(AppNoticeController.CreatePostRequest request) {
    public AppNotice setAppNotice(AppNoticeController.CreatePostRequest request) {
        //System.out.println(AppNotice.Category.valueOf(request.category.toUpperCase()).getClass());
        //System.out.println(request.category.toUpperCase().getClass());

        AppNotice appNotice = new AppNotice();

        appNotice.setCategory(AppNotice.Category.valueOf(request.category.toUpperCase()));
        appNotice.setTitle(request.title);
        appNotice.setContent(request.content);
        appNotice.setReserveAt(request.reserve_at);

        // Mybatus
        // appNoticeMapper.setAppNotice(appNotice);

        // JPA
        appNoticeRepository.save(appNotice);

        long insertId = appNotice.getId();

        List<AppNoticeDevice> list = new ArrayList<>();
        Map<String, Boolean> appNoticeOptions = new HashMap<>();

        appNoticeOptions.put("MOBILE_WEB", request.MOBILE_WEB);
        appNoticeOptions.put("SPORT_ANDROID", request.SPORT_ANDROID);
        appNoticeOptions.put("SPORT_IOS", request.SPORT_IOS);
        appNoticeOptions.put("GAME_ANDROID", request.GAME_ANDROID);
        appNoticeOptions.put("GAME_IOS", request.GAME_IOS);

        appNoticeOptions.forEach((option, value) -> {
            if(value == true) {
                AppNoticeDevice appNoticeDevice = setAppNoticeDeviceArray(option, insertId, request);
                list.add(appNoticeDevice);
            }
        });

        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        appNoticeMapper.setAppNoticeDevice(map);
        AppNotice newAppNotice = getAppNotice(insertId);
        return newAppNotice;

    }

    private AppNoticeDevice setAppNoticeDeviceArray(String mode, long insertId, AppNoticeController.CreatePostRequest request) {
        String type = mode.toLowerCase();
        AppNoticeDevice appNoticeDevice = new AppNoticeDevice();
        appNoticeDevice.setNoticeId(insertId);
        appNoticeDevice.setType(AppNoticeDevice.Type.valueOf(mode));

        switch (type) {
            case "mobile_web":
                appNoticeDevice.setNoticeTopAllowed(request.mobile_web_notice_top_allowed.equals("Y"));
                appNoticeDevice.setPopupAllowed(request.mobile_web_popup_allowed.equals("Y"));
                break;
            case "sport_android":
                appNoticeDevice.setNoticeTopAllowed(request.sport_android_notice_top_allowed.equals("Y"));
                appNoticeDevice.setPopupAllowed(request.sport_android_popup_allowed.equals("Y"));
                break;
            case "sport_ios":
                appNoticeDevice.setNoticeTopAllowed(request.sport_ios_notice_top_allowed.equals("Y"));
                appNoticeDevice.setPopupAllowed(request.sport_ios_popup_allowed.equals("Y"));
                break;
            case "game_android":
                appNoticeDevice.setNoticeTopAllowed(request.game_android_notice_top_allowed.equals("Y"));
                appNoticeDevice.setPopupAllowed(request.game_android_popup_allowed.equals("Y"));
                break;
            case "game_ios":
                appNoticeDevice.setNoticeTopAllowed(request.game_ios_notice_top_allowed.equals("Y"));
                appNoticeDevice.setPopupAllowed(request.game_ios_popup_allowed.equals("Y"));
                break;
        }

        return appNoticeDevice;
    }

}
