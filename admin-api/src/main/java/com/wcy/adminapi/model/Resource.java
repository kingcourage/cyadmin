package com.wcy.adminapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SYS_RESOURCE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resource implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(length = 2000)
    private String memory;

    @Column
    private Integer type;

    @Column(length = 100)
    private String url;

    @Column(length = 20)
    private String icon;

    @Column
    private Long parentId;

    @Column
    private Date createTime;

    @Column
    private Date updateTime;

    @Column
    private Long creatorId;

    @Column
    private Long updaterId;
}
