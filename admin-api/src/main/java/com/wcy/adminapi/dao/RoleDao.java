package com.wcy.adminapi.dao;

import com.wcy.adminapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao extends JpaRepository<Role,Long> {

    List<Role> getRolesByIdIn(List<Long> ids);
}
