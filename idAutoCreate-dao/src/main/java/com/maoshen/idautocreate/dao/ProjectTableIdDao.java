package com.maoshen.idautocreate.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.maoshen.idautocreate.domain.ProjectTableId;

@Repository
public interface ProjectTableIdDao {
    public ProjectTableId getProjectTableId(@Param("projectName")String projectName,@Param("tableName")String tableName);
    
    public long update(@Param("projectName")String projectName,@Param("tableName")String tableName);
}
