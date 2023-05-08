package com.login.repository;

import com.user.entity.UserMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<UserMember, Integer> {

    UserMember findByUserId(String userId);
    UserMember findByUserIdAndPassword(String userId, String password);
}