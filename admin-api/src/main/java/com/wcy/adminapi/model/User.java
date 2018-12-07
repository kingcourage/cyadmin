package com.wcy.adminapi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SYS_USER")
@Data
public class User {
    @Id()
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32)
    private String username;
    @Column(length = 64)
    private String password;
    @Column(length = 20)
    private String mobile;
    @Column(length = 32)
    private String nickName;
    @Column
    private Date createTime;
    @Column()
    private Date updateTime;
    @Column
    private Long creatorId;
    @Column
    private Long updaterId;
    @Column(length = 2000)
    private String memory;
}

