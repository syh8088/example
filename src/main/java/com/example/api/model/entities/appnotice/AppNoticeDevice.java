package com.example.api.model.entities.appnotice;


import com.example.api.config.LocalDateTimeAttributeConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString(exclude = "appNotice") // TODO exclude = "appNotice" 설정 안하면 에러문구 : java.lang.StackOverflowError: null
public class AppNoticeDevice extends AppNoticeCommon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "notice_id")
    private long noticeId;

    @Column(columnDefinition = "enum('MOBILE_WEB','SPORT_ANDROID','SPORT_IOS','GAME_ANDROID','GAME_IOS')")
    @Enumerated(EnumType.STRING)
    private Type type;

    private boolean noticeTopAllowed;

    private boolean popupAllowed;

    private String popupImagePath;

    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime popupStartDate;

    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime popupEndDate;


    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "notice_id", insertable = false, updatable = false)
    @JsonIgnore
    private AppNotice appNotice;

/*    @ManyToOne
    @JoinColumn(name = "noticeId", insertable = false, updatable = false)
    private AppNotice appNotice;*/

    public enum Type {
        MOBILE_WEB("MOBILE_WEB"), SPORT_ANDROID("SPORT_ANDROID"), SPORT_IOS("SPORT_IOS"), GAME_ANDROID("GAME_ANDROID"), GAME_IOS("GAME_IOS");

        String value;

        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
