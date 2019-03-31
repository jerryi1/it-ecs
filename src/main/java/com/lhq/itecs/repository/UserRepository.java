package com.lhq.itecs.repository;

import com.lhq.itecs.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface UserRepository extends JpaRepository<User,Integer>, QueryDslPredicateExecutor<User> {
    public User findByUsername(String username);
}
