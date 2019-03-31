package com.lhq.itecs.entity.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.jdo.annotations.Join;
import javax.persistence.*;

/**
 * 用户表
 * */

@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
