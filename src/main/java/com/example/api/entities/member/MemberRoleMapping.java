package com.example.api.entities.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class MemberRoleMapping extends MemeberCommon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int memberRoleMappingNo;

    @Column(nullable = false)
    private int memberNo;

    @Column(nullable = false)
    private int roleNo;
}
