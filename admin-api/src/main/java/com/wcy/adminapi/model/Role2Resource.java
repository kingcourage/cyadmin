package com.wcy.adminapi.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SYS_ROLE2RESOURCE")
@Data
public class Role2Resource implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column
    private  Long roleId;
    @Column
    private Long resourceId;
}
