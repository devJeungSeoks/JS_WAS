package com.common.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;


@MappedSuperclass
public abstract class BaseEntity {

    //등록일 자동 저장
    @Column(columnDefinition = "datetime not null comment '등록일'", updatable = false)
    private LocalDateTime regDate;

    //마지막 수정시간 자동저장
    @Column(columnDefinition = "datetime not null comment '수정일'")
    private LocalDateTime updateDate;


    @PrePersist
    protected void setRegDate(){
        regDate = LocalDateTime.now();
        updateDate = regDate;
    }

    @PreUpdate
    protected void setUpdateDate(){
        updateDate = LocalDateTime.now();
    }
}
