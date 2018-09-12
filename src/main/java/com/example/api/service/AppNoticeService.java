package com.example.api.service;

import com.example.api.controller.appnotice.AppNoticeController;
import com.example.api.entities.appnotice.AppNotice;
import com.example.api.entities.appnotice.AppNoticeDevice;
import com.example.api.entities.appnotice.AppNoticeDeviceExists;
import com.example.api.exception.ApiException;
import com.example.api.repositories.appnotice.AppNoticeDeviceRepository;
import com.example.api.repositories.appnotice.AppNoticeMapper;
import com.example.api.repositories.appnotice.AppNoticeRepository;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class AppNoticeService {

    private AppNoticeMapper appNoticeMapper;
    private AppNoticeRepository appNoticeRepository;
    private AppNoticeDeviceRepository appNoticeDeviceRepository;
    private List<String> noticeTypes = Arrays.asList("mobile_web", "sport_android", "sport_ios", "game_android", "game_ios");

    @Autowired
    public AppNoticeService(AppNoticeMapper appNoticeMapper, AppNoticeRepository appNoticeRepository, AppNoticeDeviceRepository appNoticeDeviceRepository) {
        this.appNoticeMapper = appNoticeMapper;
        this.appNoticeRepository = appNoticeRepository;
        this.appNoticeDeviceRepository = appNoticeDeviceRepository;
    }

    public List<AppNotice> getAppNoticeList() {
        List<AppNotice> appNoticeList = appNoticeMapper.getAppNoticeList(noticeTypes);
        return appNoticeList;
    }

    public AppNotice getAppNotice(long id) {
        AppNotice appNotice = appNoticeRepository.findById(id);
        return appNotice;
    }

    @Transactional
    public AppNotice updateAppNotice(long id, AppNoticeController.AppNoticePostRequest request) throws ApiException {

        AppNotice originAppNotice = appNoticeRepository.findById(id);

        AppNotice newAppNotice = new AppNotice();
        newAppNotice.setReserveAt(request.reserve_at);
        newAppNotice.setContent(request.content);
        newAppNotice.setTitle(request.title);
        newAppNotice.setCategory(AppNotice.Category.valueOf(request.category.toUpperCase()));
        newAppNotice.setId(id);

        BeanUtils.copyProperties(newAppNotice, originAppNotice);

        AppNoticeDeviceExists appNoticeDeviceExists = appNoticeMapper.getAppNoticeDeviceExists(noticeTypes, id);

        Map<String, Boolean> appNoticeOptions = new HashMap<>();
        appNoticeOptions.put("mobile_web", appNoticeDeviceExists.isMobileWeb());
        appNoticeOptions.put("sport_android", appNoticeDeviceExists.isSportAndroid());
        appNoticeOptions.put("sport_ios", appNoticeDeviceExists.isSportIos());
        appNoticeOptions.put("game_android", appNoticeDeviceExists.isGameAndroid());
        appNoticeOptions.put("game_ios", appNoticeDeviceExists.isGameIos());

        Map<String, Boolean> requestAppNoticeOptions = new HashMap<>();

        requestAppNoticeOptions.put("mobile_web", request.MOBILE_WEB);
        requestAppNoticeOptions.put("sport_android", request.SPORT_ANDROID);
        requestAppNoticeOptions.put("sport_ios", request.SPORT_IOS);
        requestAppNoticeOptions.put("game_android", request.GAME_ANDROID);
        requestAppNoticeOptions.put("game_ios", request.GAME_IOS);

        appNoticeOptions.forEach((key, value) -> {

            if(value && BooleanUtils.isTrue(requestAppNoticeOptions.get(key))) {

                AppNoticeDevice newAppNoticeDevice = null;
                newAppNoticeDevice = setAppNoticeDeviceArray(key.toUpperCase(), id, request);
                appNoticeMapper.updateAppNoticeDevice(newAppNoticeDevice);

                //AppNoticeDevice originNewAppNoticeDevice = appNoticeDeviceRepository.findByNoticeIdAndType(request.getId(), AppNoticeDevice.Type.valueOf(key.toUpperCase()));
                //BeanUtils.copyProperties(newAppNoticeDevice, originNewAppNoticeDevice);
            } else if(value && !BooleanUtils.isTrue(requestAppNoticeOptions.get(key))) {
                //appNoticeDeviceRepository.deleteAllByIdAndType(request.getId(), AppNoticeDevice.Type.valueOf(key.toUpperCase()));
                appNoticeMapper.deleteAppNoticeDevice(id, AppNoticeDevice.Type.valueOf(key.toUpperCase()));
            } else if(!value && BooleanUtils.isTrue(requestAppNoticeOptions.get(key))) {
                AppNoticeDevice newAppNoticeDevice = setAppNoticeDeviceArray(key.toUpperCase(), id, request);
                //appNoticeDeviceRepository.save(newAppNoticeDevice);

                List<AppNoticeDevice> list = new ArrayList<>();
                Map<String, Object> map = new HashMap<>();
                list.add(newAppNoticeDevice);
                map.put("list", list);
                appNoticeMapper.setAppNoticeDevice(map);

            }
        });

        return newAppNotice;
    }

    public AppNotice setAppNotice(AppNoticeController.AppNoticePostRequest request) {
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

    private AppNoticeDevice setAppNoticeDeviceArray(String mode, long insertId, AppNoticeController.AppNoticePostRequest request) {
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
