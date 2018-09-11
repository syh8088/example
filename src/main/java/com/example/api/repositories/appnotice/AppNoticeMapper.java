package com.example.api.repositories.appnotice;

import com.example.api.entities.appnotice.AppNotice;
import com.example.api.entities.appnotice.AppNoticeDevice;
import com.example.api.entities.appnotice.AppNoticeDeviceExists;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AppNoticeMapper {

    List<AppNotice> getAppNoticeList(List<String> subSelectArray);

    AppNoticeDeviceExists getAppNoticeDeviceExists(@Param("noticeName") List<String> subSelectArray, @Param("id") int id);

    int updateAppNoticeDevice(AppNoticeDevice appNoticeDevice);
    int deleteAppNoticeDevice(@Param("noticeId") Long noticeId, @Param("type") AppNoticeDevice.Type type);

    int setAppNotice(AppNotice appNotice);
    int setAppNoticeDevice(Map<String, Object> map);

}
