package com.example.api.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Slf4j
@Getter
@Setter
@Alias("Board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "enum('NOTICE', 'EVENT', 'UPDATE')")
    @Enumerated(EnumType.STRING)
    private Category category;

    private String title;

    @Lob
    private String content;

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
