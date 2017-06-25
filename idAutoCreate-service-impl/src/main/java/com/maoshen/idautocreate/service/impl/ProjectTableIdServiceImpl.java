package com.maoshen.idautocreate.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maoshen.component.mybatis.Master;
import com.maoshen.component.mybatis.Slave;
import com.maoshen.idautocreate.dao.ProjectTableIdDao;
import com.maoshen.idautocreate.domain.ProjectTableId;
import com.maoshen.idautocreate.service.dto.ProjectTableIdDto;

@Service("projectTableIdServiceImpl")
public class ProjectTableIdServiceImpl {
	@Autowired
    public ProjectTableIdDao projectTableIdDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectTableIdServiceImpl.class);
	
	@Master
	public ProjectTableIdDto getProjectTableId(String projectName,String tableName) throws Exception{
		if(StringUtils.isBlank(projectName) || StringUtils.isBlank(tableName)){
			throw new Exception("projectName or tableName is null");
		}
		ProjectTableId projectTableId = projectTableIdDao.getProjectTableId(projectName, tableName);
		ProjectTableIdDto ProjectTableIdDto = new ProjectTableIdDto();
		return ProjectTableIdDto;
	}
}
