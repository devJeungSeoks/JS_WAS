package com.user.repository;

import com.user.entity.UserMemberDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<UserMemberDetail, Integer> {

    UserMemberDetail findBySsn(String ssn);
}
