package com.maoshen.idautocreate.duo;

import java.io.Serializable;

public class ProjectTableIdDuo implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	public String projectName;
	public String tableName;
	public Long startId;
	public Long endId;
	
    public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Long getStartId() {
		return startId;
	}

	public void setStartId(Long startId) {
		this.startId = startId;
	}

	public Long getEndId() {
		return endId;
	}

	public void setEndId(Long endId) {
		this.endId = endId;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
