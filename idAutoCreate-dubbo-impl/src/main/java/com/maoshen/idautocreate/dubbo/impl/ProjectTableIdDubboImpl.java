package com.maoshen.idautocreate.dubbo.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maoshen.idautocreate.dubbo.ProjectTableIdDubbo;
import com.maoshen.idautocreate.duo.ProjectTableIdDuo;
import com.maoshen.idautocreate.service.dto.ProjectTableIdDto;
import com.maoshen.idautocreate.service.impl.ProjectTableIdServiceImpl;

@Service("projectTableIdDubboImpl")
public class ProjectTableIdDubboImpl implements ProjectTableIdDubbo {
	private static final Logger LOGGER = Logger.getLogger(ProjectTableIdDubboImpl.class);

	@Autowired
	private ProjectTableIdServiceImpl projectTableIdServiceImpl;
	
	@Override
	public ProjectTableIdDuo getProjectTableIdDto(String projectName,String tableName) throws Exception{
		if(StringUtils.isBlank(projectName) || StringUtils.isBlank(tableName)){
			throw new Exception("projectName or tableName is null");
		}
		ProjectTableIdDuo ProjectTableIdDuo = new ProjectTableIdDuo();
		//redis lock
		ProjectTableIdDto dto = projectTableIdServiceImpl.getProjectTableId(projectName,tableName);
		return ProjectTableIdDuo;
	}
}
