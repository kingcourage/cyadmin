package com.wcy.adminapi.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SYS_ROLE")
@Data
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 2000)
    private String memory;

    @Column
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
