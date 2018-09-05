package com.example.api.entities.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class MemberGroup extends Common {
    @Id
    private long memberGroupNo;
    private String name;
    private String description;

    //OneToMany
    @OneToMany(mappedBy = "memberGroup", fetch = FetchType.LAZY)
    Set<Member> members = new HashSet<>();
}
