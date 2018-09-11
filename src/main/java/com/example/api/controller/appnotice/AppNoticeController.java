package com.example.api.controller.appnotice;

import com.example.api.entities.appnotice.AppNotice;
import com.example.api.service.AppNoticeService;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("appnotices")
public class AppNoticeController {

    private AppNoticeService appNoticeService;

    @Autowired
    public AppNoticeController(AppNoticeService appNoticeService) {
        this.appNoticeService = appNoticeService;
    }

    @GetMapping("getAppNoticeList/")
    @ApiOperation(value = "Get appnotice into type", notes = "Returns the appNotice and each appNoticeDevice of the type.")
    public ResponseEntity<List<AppNotice>> getAppNoticeList() {
        return ResponseEntity.ok().body(appNoticeService.getAppNoticeList());
    }

    @GetMapping("getAppNotice/{id}")
    @ApiOperation(value = "Get appnotice into type", notes = "Returns the appNotice and each appNoticeDevice of the type.")
    public ResponseEntity<AppNotice> getAppNotice(@PathVariable("id") @ApiParam(value = "id") long id) {
        return ResponseEntity.ok().body(appNoticeService.getAppNotice(id));
    }

    @PostMapping("create")
    @ApiOperation(value = "Create appNotice", notes = "Creates a appNotice and returns the entity.")
    public ResponseEntity<AppNotice> setAppNotice(
            @RequestBody CreatePostRequest request
    ) {
       return ResponseEntity.ok().body(appNoticeService.setAppNotice(request));
    }

    @PostMapping("update")
    @ApiOperation(value = "Update appNotice", notes = "Updates a appNotice and returns the entity.")
    public ResponseEntity<AppNotice> updateAppNotice(
            @RequestBody CreatePostRequest request
    ) throws Exception {
        return ResponseEntity.ok().body(appNoticeService.updateAppNotice(request));
    }

    @NoArgsConstructor
    @Data
    public static class CreatePostRequest {

        public long id;
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
