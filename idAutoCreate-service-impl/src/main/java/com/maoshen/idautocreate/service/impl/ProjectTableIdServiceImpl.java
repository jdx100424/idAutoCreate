package com.maoshen.idautocreate.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maoshen.component.base.errorcode.BaseErrorCode;
import com.maoshen.component.exception.BaseException;
import com.maoshen.component.mybatis.Master;
import com.maoshen.component.redis.RedisService;
import com.maoshen.idautocreate.constant.CommonKey;
import com.maoshen.idautocreate.dao.ProjectTableIdDao;
import com.maoshen.idautocreate.domain.ProjectTableId;
import com.maoshen.idautocreate.service.dto.ProjectTableIdDto;

@Service("projectTableIdServiceImpl")
public class ProjectTableIdServiceImpl {
	@Autowired
    public ProjectTableIdDao projectTableIdDao;
	@Autowired
	private RedisService redisService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectTableIdServiceImpl.class);
	
	@Master
	public ProjectTableIdDto getProjectTableId(String projectName,String tableName) throws Exception{
		if(StringUtils.isBlank(projectName) || StringUtils.isBlank(tableName)){
			throw new Exception("projectName or tableName is null");
		}
		String projectTableIdLock = String.format(CommonKey.IDAUTOCREATE_PROJECT_NAME_LOCK, projectName,tableName);
		try {
			redisService.lock(projectTableIdLock);
			ProjectTableId projectTableId = projectTableIdDao.getProjectTableId(projectName, tableName);
			if(projectTableId==null || projectTableId.getId()==null){
				throw new Exception("projectTableId is null");
			}
			//add number
			long resultlong = projectTableIdDao.update(projectName, tableName);
			if(resultlong <= 0L){
				throw new Exception("projectTableId update fail");
			}
			
			ProjectTableIdDto projectTableIdDto = new ProjectTableIdDto();
			BeanUtils.copyProperties(projectTableIdDto, projectTableId);
			return projectTableIdDto;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new BaseException("idAutoCreate", BaseErrorCode.SERVICE_EXCEPTION);
		} finally {
			redisService.unlock(projectTableIdLock);
		}
	}
}
