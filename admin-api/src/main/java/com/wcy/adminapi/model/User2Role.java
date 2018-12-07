package com.wcy.adminapi.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SYS_USER2ROLE")
@Data
public class User2Role {
    @Id
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long roleId;


}
