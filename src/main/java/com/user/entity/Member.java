package com.user.entity;

import com.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Member extends BaseEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "member_seq")
    @Column(nullable = false, name = "member_no")
    @Comment("회원 고유번호")
    private Long no;

    @Column(length = 20, unique = true, nullable = false)
    @Comment("아이디")
    private String memberId;

    @Column(length = 300, nullable = false)
    @Comment("패스워드")
    private String password;

    @Column(length = 1, nullable = false)
    @Comment("관리자여부")
    private String adminYn;

    @Column(length = 1)
    @Comment("활성여부")
    private String saveStatus;

    @JsonBackReference
    @OneToOne(mappedBy = "member", optional = false, cascade = CascadeType.ALL)
    private MemberDetail memberDetail;

    @JsonBackReference
    @OneToOne(mappedBy = "member", optional = false, cascade = CascadeType.ALL)
    private MemberCash memberCash;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return memberId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

