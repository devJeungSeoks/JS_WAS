package com.login.repository;

import com.user.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Member, Integer> {

    Member findByMemberId(String memberId);
    Member findByMemberIdAndPassword(String memberId, String password);
}