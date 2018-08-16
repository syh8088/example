package com.example.api.controller;

import com.example.api.config.BooleanToYNConverter;
import com.example.api.entities.appnotice.AppNotice;
import com.example.api.service.AppNoticeService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Convert;
import java.time.LocalDateTime;

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

    @PostMapping("/appnotice/create")
    public ResponseEntity<AppNotice> setAppNotice (
    //public void setAppNotice (
            @RequestBody CreatePostRequest request
    ) throws Exception {
        return ResponseEntity.ok().body(appNoticeService.setAppNotice(request));
    }

    @NoArgsConstructor
    @Data
    @JsonPropertyOrder({"subject", "content"})
    public static class CreatePostRequest {
        @Convert(converter = BooleanToYNConverter.class)
        public String mobile_web_notice_top_allowed;
        public String mobile_web_popup_allowed;
        public String sport_android_notice_top_allowed;
        public String sport_android_popup_allowed;
        public String sport_ios_notice_top_allowed;
        public String sport_ios_popup_allowed;
        public String game_android_notice_top_allowed;
        public String game_android_popup_allowed;
        public String game_ios_notice_top_allowed;
        public String game_ios_popup_allowed;


        public Boolean MOBILE_WEB;
        public Boolean SPORT_ANDROID;
        public Boolean SPORT_IOS;
        public Boolean GAME_ANDROID;
        public Boolean GAME_IOS;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        public LocalDateTime reserve_at;


        public String category;

        public String title;
        public String content;

    }

}
