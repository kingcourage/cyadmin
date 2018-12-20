package com.wcy.adminapi.dao;

import com.wcy.adminapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<User,Long>, JpaSpecificationExecutor {
     User findByUsername(String username);
     User findByEmail(String email);
}
