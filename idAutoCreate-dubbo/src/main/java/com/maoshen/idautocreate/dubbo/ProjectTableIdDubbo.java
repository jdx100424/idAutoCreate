package com.maoshen.idautocreate.dubbo;

import com.maoshen.idautocreate.duo.ProjectTableIdDuo;

public interface ProjectTableIdDubbo {
	/**
	 * 获取指定项目新的ID开始和结束值
	 * @param id
	 * @return
	 */
	public ProjectTableIdDuo getProjectTableIdDto(String projectName,String tableName) throws Exception;
}
