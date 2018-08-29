package com.example.api.repositories.appnotice;

import com.example.api.entities.appnotice.AppNotice;
import com.example.api.entities.appnotice.AppNoticeDevice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AppNoticeMapper {

    List<AppNotice> getAppNoticeList(List<String> subSelectArray);

    int setAppNotice(AppNotice appNotice);
    int setAppNoticeDevice(Map<String, AppNoticeDevice> map);

}
