package com.user.repository;

import com.user.entity.UserCash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCashRepository extends JpaRepository<UserCash, Integer> {

    UserCash findByUserMemberUserNo(Long userNo);
}
