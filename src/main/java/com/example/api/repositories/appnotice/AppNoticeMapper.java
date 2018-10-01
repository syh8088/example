package com.example.api.repositories.appnotice;

import com.example.api.model.entities.appnotice.AppNotice;
import com.example.api.model.entities.appnotice.AppNoticeDevice;
import com.example.api.model.entities.appnotice.AppNoticeDeviceExists;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AppNoticeMapper {

    List<AppNotice> getAppNoticeList(List<String> noticeTypes);

    AppNoticeDeviceExists getAppNoticeDeviceExists(@Param("noticeTypes") List<String> noticeTypes, @Param("id") long id);

    int updateAppNoticeDevice(AppNoticeDevice appNoticeDevice);
    int deleteAppNoticeDevice(@Param("noticeId") long noticeId, @Param("type") AppNoticeDevice.Type type);

    int setAppNotice(AppNotice appNotice);
    int setAppNoticeDevice(Map<String, Object> map);

}
