package com.example.api.controller.appnotice;

import com.example.api.model.entities.appnotice.AppNotice;
import com.example.api.service.AppNoticeService;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
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
@Api(tags = "AppNotice")
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
            @RequestBody AppNoticePostRequest request
    ) {
       return ResponseEntity.ok().body(appNoticeService.setAppNotice(request));
    }

    @PutMapping("update/{id}")
    @ApiOperation(value = "Update appNotice", notes = "Updates a appNotice and returns the entity.")
    public ResponseEntity<AppNotice> updateAppNotice(
            @PathVariable("id") @ApiParam(value = "AppNotice id") long id,
            @RequestBody AppNoticePostRequest request
    ) throws Exception {
        return ResponseEntity.ok().body(appNoticeService.updateAppNotice(id, request));
    }

    @NoArgsConstructor
    @Data
    public static class AppNoticePostRequest {

        public String mobileWebNoticeTopAllowed;
        public String mobileWebPopupAllowed;
        public String sportAndroidNoticeTopAllowed;
        public String sportAndroidPopupAllowed;
        public String sportIosNoticeTopAllowed;
        public String sportIosPopupAllowed;
        public String gameAndroidNoticeTopAllowed;
        public String gameAndroidPopupAllowed;
        public String gameIosNoticeTopAllowed;
        public String gameIosPopupAllowed;

        public Boolean mobileWeb;
        public Boolean sportAndroid;
        public Boolean sportIos;
        public Boolean gameAndroid;
        public Boolean gameIos;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        public LocalDateTime reserveAt;

        public String category;

        public String title;
        public String content;

    }

}
