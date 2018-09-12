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
    private List<String> noticeTypes = Arrays.asList("mobileWeb", "sportAndroid", "sportIos", "gameAndroid", "gameIos");

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
        newAppNotice.setReserveAt(request.reserveAt);
        newAppNotice.setContent(request.content);
        newAppNotice.setTitle(request.title);
        newAppNotice.setCategory(AppNotice.Category.valueOf(request.category.toUpperCase()));
        newAppNotice.setId(id);

        BeanUtils.copyProperties(newAppNotice, originAppNotice);

        List<String> newNoticeTypes = new ArrayList<>();
        noticeTypes.stream().forEach(type -> {
            newNoticeTypes.add(camelToDbStyle(type));
        });

        AppNoticeDeviceExists appNoticeDeviceExists = appNoticeMapper.getAppNoticeDeviceExists(newNoticeTypes, id);

        Map<String, Boolean> appNoticeOptions = new HashMap<>();
        appNoticeOptions.put("mobileWeb", appNoticeDeviceExists.isMobileWeb());
        appNoticeOptions.put("sportAndroid", appNoticeDeviceExists.isSportAndroid());
        appNoticeOptions.put("sportIos", appNoticeDeviceExists.isSportIos());
        appNoticeOptions.put("gameAndroid", appNoticeDeviceExists.isGameAndroid());
        appNoticeOptions.put("gameIos", appNoticeDeviceExists.isGameIos());

        Map<String, Boolean> requestAppNoticeOptions = new HashMap<>();

        requestAppNoticeOptions.put("mobileWeb", request.mobileWeb);
        requestAppNoticeOptions.put("sportAndroid", request.sportAndroid);
        requestAppNoticeOptions.put("sportIos", request.sportIos);
        requestAppNoticeOptions.put("gameAndroid", request.gameAndroid);
        requestAppNoticeOptions.put("gameIos", request.gameIos);

        appNoticeOptions.forEach((key, value) -> {

            if(value && BooleanUtils.isTrue(requestAppNoticeOptions.get(key))) {

                AppNoticeDevice newAppNoticeDevice = null;
                newAppNoticeDevice = setAppNoticeDeviceArray(key, id, request);
                appNoticeMapper.updateAppNoticeDevice(newAppNoticeDevice);

                //AppNoticeDevice originNewAppNoticeDevice = appNoticeDeviceRepository.findByNoticeIdAndType(request.getId(), AppNoticeDevice.Type.valueOf(key.toUpperCase()));
                //BeanUtils.copyProperties(newAppNoticeDevice, originNewAppNoticeDevice);
            } else if(value && !BooleanUtils.isTrue(requestAppNoticeOptions.get(key))) {
                //appNoticeDeviceRepository.deleteAllByIdAndType(request.getId(), AppNoticeDevice.Type.valueOf(key.toUpperCase()));
                appNoticeMapper.deleteAppNoticeDevice(id, AppNoticeDevice.Type.valueOf(camelToDbStyle(key)));
            } else if(!value && BooleanUtils.isTrue(requestAppNoticeOptions.get(key))) {
                AppNoticeDevice newAppNoticeDevice = setAppNoticeDeviceArray(key, id, request);
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
        appNotice.setReserveAt(request.reserveAt);
        // Mybatus
        // appNoticeMapper.setAppNotice(appNotice);

        // JPA
        appNoticeRepository.save(appNotice);

        long insertId = appNotice.getId();

        List<AppNoticeDevice> list = new ArrayList<>();
        Map<String, Boolean> appNoticeOptions = new HashMap<>();

        appNoticeOptions.put("mobileWeb", request.mobileWeb);
        appNoticeOptions.put("sportAndroid", request.sportAndroid);
        appNoticeOptions.put("sportIos", request.sportIos);
        appNoticeOptions.put("gameAndroid", request.gameAndroid);
        appNoticeOptions.put("gameIos", request.gameIos);

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

    private AppNoticeDevice setAppNoticeDeviceArray(String type, long insertId, AppNoticeController.AppNoticePostRequest request) {
        //String type = mode.toLowerCase();
        AppNoticeDevice appNoticeDevice = new AppNoticeDevice();
        appNoticeDevice.setNoticeId(insertId);
        appNoticeDevice.setType(AppNoticeDevice.Type.valueOf(camelToDbStyle(type)));

        switch (type) {
            case "mobileWeb":
                appNoticeDevice.setNoticeTopAllowed(request.mobileWebNoticeTopAllowed.equals("Y"));
                appNoticeDevice.setPopupAllowed(request.mobileWebPopupAllowed.equals("Y"));
                break;
            case "sportAndroid":
                appNoticeDevice.setNoticeTopAllowed(request.sportAndroidNoticeTopAllowed.equals("Y"));
                appNoticeDevice.setPopupAllowed(request.sportAndroidPopupAllowed.equals("Y"));
                break;
            case "sportIos":
                appNoticeDevice.setNoticeTopAllowed(request.sportIosNoticeTopAllowed.equals("Y"));
                appNoticeDevice.setPopupAllowed(request.sportIosPopupAllowed.equals("Y"));
                break;
            case "gameAndroid":
                appNoticeDevice.setNoticeTopAllowed(request.gameAndroidNoticeTopAllowed.equals("Y"));
                appNoticeDevice.setPopupAllowed(request.gameAndroidPopupAllowed.equals("Y"));
                break;
            case "gameIos":
                appNoticeDevice.setNoticeTopAllowed(request.gameIosNoticeTopAllowed.equals("Y"));
                appNoticeDevice.setPopupAllowed(request.gameIosPopupAllowed.equals("Y"));
                break;
        }

        return appNoticeDevice;
    }

    private String camelToDbStyle(String value) {
        String regex = "([a-z])([A-Z])";
        String replacement = "$1_$2";
        String replaceValue = value.replaceAll(regex, replacement).toUpperCase();
        return replaceValue;
    }

}
