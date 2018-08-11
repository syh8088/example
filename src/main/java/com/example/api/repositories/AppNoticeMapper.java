package com.example.api.repositories;

import com.example.api.entities.appnotice.AppNotice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AppNoticeMapper {

    AppNotice getAppNoticeList(Map<String, List> subSelectArray);

}
