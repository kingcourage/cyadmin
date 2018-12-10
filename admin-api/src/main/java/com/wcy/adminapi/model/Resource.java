package com.wcy.adminapi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SYS_PERMISSION")
@Data
public class Resource {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(length = 2000)
    private String memory;

    @Column
    private Integer type;

    @Column
    private String url;

    @Column
    private Date createTime;

    @Column
    private Date updateTime;

    @Column
    private Long creatorId;

    @Column
    private Long updaterId;
}
