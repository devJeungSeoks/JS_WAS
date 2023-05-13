package com.common.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    //등록일 자동 저장
    @CreatedDate
    @Column(columnDefinition = "datetime not null comment '등록일'", updatable = false)
    private LocalDateTime regDate;

    //마지막 수정시간 자동저장
    @LastModifiedDate
    @Column(columnDefinition = "datetime not null comment '수정일'")
    private LocalDateTime updateDate;
}
