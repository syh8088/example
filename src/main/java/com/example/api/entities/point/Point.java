package com.example.api.entities.point;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Alias("Point")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long no;

    private long memberNo;

    @CreatedDate
    private LocalDateTime create_at;
    private String content;
    private long point;
    private String type;
}
