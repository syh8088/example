package com.example.api.model.entities.member;


import com.example.api.annotation.Encrypt;
import com.example.api.config.LocalDateTimeAttributeConverter;
import com.example.api.model.enums.OauthType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Member extends MemberCommon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberNo;

    private String id;

    @Encrypt
    @Column(name = "example_password")
    private String password;

    private String name;

    private String email;

    private Long point;

    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime todayLogin;

    @Enumerated(EnumType.STRING)
    private OauthType oauthType;

    private String oauthId;

    private String snsYn;

    // ManyToOne
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_group_no")
    @JsonIgnore
    private MemberGroup memberGroup;

    // ManyToMany
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "member_role_mapping",
                joinColumns = @JoinColumn(name = "memberNo"),
                inverseJoinColumns = @JoinColumn(name = "roleNo"))
    private List<Role> roles = new ArrayList<>();
}
