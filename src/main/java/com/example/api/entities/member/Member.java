package com.example.api.entities.member;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class Member extends Common {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long no;
    private String id;
    private String password;
    private String name;
    private String email;
    private Long point;

}
