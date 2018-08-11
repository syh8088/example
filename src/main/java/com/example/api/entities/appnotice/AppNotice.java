package com.example.api.entities.appnotice;


import com.example.api.config.LocalDateTimeAttributeConverter;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Slf4j
@Data
@Alias("AppNotice")
public class AppNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean mobileWeb;
    private boolean sportAndroid;
    private boolean sportIos;
    private boolean gameAndroid;
    private boolean gameIos;

    //private Map<String, String> subSelectArray;

    @Column(columnDefinition = "enum('NOTICE', 'EVENT', 'UPDATE')")
    @Enumerated(EnumType.STRING)
    private Category category;

    private String title;

    @Lob
    private String content;

    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime reserveAt;

    private long viewCount;

    public enum Category {
        NOTICE("NOTICE"), EVENT("EVENT"), UPDATE("UPDATE");

        private String value;

        Category(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }







}
