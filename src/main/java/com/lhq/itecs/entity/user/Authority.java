package com.lhq.itecs.entity.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(of = "id")
public class Authority {
    //权限id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //权限名称
    private String name;
    //权限和role 之间的关系

    @ManyToMany
    @JoinTable(name = "r_role_auth",
            joinColumns = {@JoinColumn(name = "auth_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roleList;

    //父类权限
    private Integer parentId;

}
