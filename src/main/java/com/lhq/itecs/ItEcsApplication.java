package com.lhq.itecs;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class ItEcsApplication {

    @Autowired
    private EntityManager entityManager;

    //配置entity
    @Autowired
    private JPAQueryFactory jpaQueryFactory(){
        return new JPAQueryFactory(entityManager);
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("lhq032613"));
        SpringApplication.run(ItEcsApplication.class, args);
    }

}
