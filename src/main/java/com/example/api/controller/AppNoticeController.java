package com.example.api.controller;

import com.example.api.entities.appnotice.AppNotice;
import com.example.api.service.AppNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppNoticeController {

    private AppNoticeService appNoticeService;

    @Autowired
    public AppNoticeController(AppNoticeService appNoticeService) {
        this.appNoticeService = appNoticeService;
    }

    @GetMapping("/appnotice/getAppNoticeList/")
    public ResponseEntity<AppNotice> getAppNoticeList() {
        return ResponseEntity.ok().body(appNoticeService.getAppNoticeList());
    }

    @GetMapping("/appnotice/getAppNotice/{id}")
    public ResponseEntity<AppNotice> getAppNotice(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(appNoticeService.getAppNotice(id));
    }
}
