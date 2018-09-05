package com.example.api.entities.member;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

abstract class Common {

    @Type(type = "yes_no")
    private Boolean deleteYn = false;

    @CreatedDate
    private LocalDateTime registerYmdt;

    @LastModifiedDate
    private LocalDateTime updateYmdt;
}
