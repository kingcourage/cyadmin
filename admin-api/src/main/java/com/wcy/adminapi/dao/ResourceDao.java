package com.wcy.adminapi.dao;

import com.wcy.adminapi.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceDao extends JpaRepository<Resource,Long> {
    Resource getResourceByUrlEquals(String url);

    List<Resource> getResourcesByTypeEquals(Integer type);

    List<Resource> getResourcesByTypeEqualsAndIdIn(Integer type,List<Long> ids);

    List<Resource> getResourcesByParentIdEquals(Long parentId);
}
