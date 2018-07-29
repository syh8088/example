package com.example.api.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@Alias("BoardList")
public class BoardList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    private String boardId;

    private long num;
    private String reply;

    private long parent;

    private boolean isComment;

    private long comment;

    private String commentReply;

    private String subject;

    private String content;

    private long hit;

    private String password;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private String createBy;

    private String updateBy;

    private String ip;

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
