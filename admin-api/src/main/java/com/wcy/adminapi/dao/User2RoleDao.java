package com.wcy.adminapi.dao;

import com.wcy.adminapi.model.User2Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User2RoleDao extends JpaRepository<User2Role,Long> {

    List<User2Role> findAllByUserIdEquals(Long userId);
}
