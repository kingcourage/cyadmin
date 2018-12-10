package com.wcy.adminapi.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "SYS_USER2ROLE")
@Data
public class User2Role {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long roleId;


}
