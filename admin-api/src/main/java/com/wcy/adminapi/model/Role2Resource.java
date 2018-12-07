package com.wcy.adminapi.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SYS_ROLE2PERMISSION")
@Data
public class Role2Resource {
    @Id
    private Long id;
    @Column
    private  Long roleId;
    @Column
    private Long resourceId;
}
