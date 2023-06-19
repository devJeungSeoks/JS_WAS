package com.user.entity;

import com.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "member_seq")
    @Column(nullable = false, name = "member_no")
    @Comment("회원 고유번호")
    private Long no;

    @Column(length = 20, unique = true, nullable = false)
    @Comment("아이디")
    private String memberId;

    @Column(length = 255, nullable = false)
    @Comment("패스워드")
    private String password;

    @Column(length = 1, nullable = false)
    @Comment("관리자여부")
    private String adminYn;
    @Column(length = 1, nullable = false)
    @Comment("활성여부")
    private String saveStatus;

    @JsonManagedReference
    @OneToOne(mappedBy = "member", optional = false, cascade = CascadeType.ALL)
    private MemberDetail memberDetail;

    @JsonManagedReference
    @OneToOne(mappedBy = "member", optional = false, cascade = CascadeType.ALL)
    private MemberCash memberCash;

}

