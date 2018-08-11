package com.example.api.controller;

import com.example.api.entities.appnotice.AppNotice;
import com.example.api.service.AppNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppNoticeController {

    private AppNoticeService appNoticeService;

    @Autowired
    public AppNoticeController(AppNoticeService appNoticeService) {
        this.appNoticeService = appNoticeService;
    }

    @GetMapping("/mapper/appnotice/getAppNoticeList/")
    public ResponseEntity<AppNotice> getAppNoticeList() {
    //public void getAppNoticeList() {
        appNoticeService.getAppNoticeList();

        return ResponseEntity.ok().body(appNoticeService.getAppNoticeList());
    }

}
