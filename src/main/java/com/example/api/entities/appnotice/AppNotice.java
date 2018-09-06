package com.example.api.entities.appnotice;


import com.example.api.config.LocalDateTimeAttributeConverter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Alias("AppNotice")
public class AppNotice extends AppNoticeCommon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // TODO com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown column 'appnotice0_.game_android' in 'field list'
    // 살리면서 할수 있나?

    @Transient
    private boolean mobileWeb;
    @Transient
    private boolean sportAndroid;
    @Transient
    private boolean sportIos;
    @Transient
    private boolean gameAndroid;
    @Transient
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

    @OneToMany(mappedBy = "appNotice", fetch = FetchType.EAGER)
    private Set<AppNoticeDevice> appNoticeDevice = new HashSet<>();
/*    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "app_notice_device",
                joinColumns = @JoinColumn(name = "noticeId"))
    private List<AppNoticeDevice> appNoticeDevices = new ArrayList<>();*/


    public enum Category {
        NOTICE("NOTICE"), EVENT("EVENT"), UPDATE("UPDATE");

        String value;

        Category(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
