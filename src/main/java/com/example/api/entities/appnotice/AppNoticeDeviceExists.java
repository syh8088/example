package com.example.api.entities.appnotice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;


@Getter
@Setter
@ToString
@Alias("AppNoticeDeviceExists")
public class AppNoticeDeviceExists {
    private boolean mobileWeb;
    private boolean sportAndroid;
    private boolean sportIos;
    private boolean gameAndroid;
    private boolean gameIos;
}
