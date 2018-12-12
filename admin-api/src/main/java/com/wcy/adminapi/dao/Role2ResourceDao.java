package com.wcy.adminapi.dao;

import com.wcy.adminapi.model.Role2Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Role2ResourceDao extends JpaRepository<Role2Resource,Long> {
    List<Role2Resource> getRole2ResourceByResourceIdEquals(Long id);

    List<Role2Resource> getRole2ResourceByRoleIdIn(List<Long> ids);
}
