package com.example.api.model.entities.member;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Convert;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

abstract class MemeberCommon {

    @Type(type = "yes_no")
    @Convert(disableConversion = true)
    private Boolean deleteYn = false;

    @CreatedDate
    private LocalDateTime registerYmdt;

    @LastModifiedDate
    private LocalDateTime updateYmdt;
}
