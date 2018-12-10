package com.wcy.adminapi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "SYS_ROLE2PERMISSION")
@Data
public class Role2Resource {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column
    private  Long roleId;
    @Column
    private Long resourceId;
}
