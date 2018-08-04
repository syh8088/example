package com.example.api.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Alias("BoardList")
public class BoardList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String boardId;
    private long num;

    private String reply;

    private long parent;

    private boolean isComment;

    // TODO 주석 처리하면 문제 없다 왜?
    //private long comment;

    private String commentReply;

    private String subject;
    @Lob
    private String content;

    private long hit;

    private String password;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private String createBy;
    private String updateBy;
    private String ip;

    @Setter
    private boolean isPhoto;
    private boolean isBest;

    @Column(columnDefinition = "enum('PC','MOBILE')")
    @Enumerated(EnumType.STRING)
    private Device device;

    public enum Device {
        PC("PC"), MOBILE("MOBILE");

        private String value;

        Device(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }
}
