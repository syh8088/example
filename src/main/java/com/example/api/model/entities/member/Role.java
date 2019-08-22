package com.example.api.model.entities.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "role")
public class Role extends MemberCommon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleNo;

    @Column(nullable = false)
    private String name;
}
