package com.example.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MemberRequest {
    @NotNull
    private String email;
    @NotNull
    private String id;
    @NotNull
    private String password;
    @NotNull
    private String snsYn;
    private String name;
}
