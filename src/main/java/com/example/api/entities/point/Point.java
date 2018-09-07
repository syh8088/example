package com.example.api.entities.point;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long no;

    private Long memberId;

    @CreatedDate
    private LocalDateTime create_at;
    private String content;
    private Long point;
    private String type;
}
