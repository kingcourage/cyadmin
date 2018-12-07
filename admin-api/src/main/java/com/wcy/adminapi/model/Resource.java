package com.wcy.adminapi.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "SYS_PERMISSION")
@Data
public class Resource {
    @Id
    private Long id;

    @Column(length = 100)
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
