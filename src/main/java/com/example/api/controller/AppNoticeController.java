package com.example.api.controller;

import com.example.api.config.BooleanToYNConverter;
import com.example.api.config.LocalDateTimeAttributeConverter;
import com.example.api.entities.appnotice.AppNotice;
import com.example.api.entities.appnotice.AppNoticeDevice;
import com.example.api.service.AppNoticeService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    //public ResponseEntity<BoardList> setAppNotice (
    public ResponseEntity<AppNotice> setAppNotice (
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

        //@JsonFormat(pattern = "yyyy-MM-dd")
        //private LocalDateTime reserve_at;


        //private AppNotice.Category category;

        public String title;
        public String content;

    }

}
