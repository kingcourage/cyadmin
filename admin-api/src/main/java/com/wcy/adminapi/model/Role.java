package com.wcy.adminapi.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "SYS_ROLE")
@Data
public class Role {
    @Id
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 2000)
    private String memory;


    private Integer type;

    @Column
    private Date createTime;

    @Column
    private Date updateTime;

    @Column
    private Long creatorId;

    @Column
    private Long updaterId;
}
