package com.wcy.adminapi.dao;

import com.wcy.adminapi.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceDao extends JpaRepository<Resource,Long> {
    Resource getResourceByUrlEquals(String url);
}
