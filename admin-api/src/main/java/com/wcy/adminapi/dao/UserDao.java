package com.wcy.adminapi.dao;

import com.wcy.adminapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
     List<User> findByUsername(String username);
}
