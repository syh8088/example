package com.example.api.repositories.point;

import com.example.api.entities.point.Point;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PointMapper {
    long getSumPoint(@Param("memberNo") long memberNo);
}
