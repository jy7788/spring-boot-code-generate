package com.oneconnect.sme.foundation.generator.entity;

import java.io.Serializable;

public class PropertiesRequest  implements Serializable{

	private static final long serialVersionUID = 1L;
    
	private String tableName;
	private String filePath;
	private String pagePath;
	private String exportTemplate;
	private String exportPackage;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getPagePath() {
		return pagePath;
	}
	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}
	public String getExportTemplate() {
		return exportTemplate;
	}
	public void setExportTemplate(String exportTemplate) {
		this.exportTemplate = exportTemplate;
	}
	public String getExportPackage() {
		return exportPackage;
	}
	public void setExportPackage(String exportPackage) {
		this.exportPackage = exportPackage;
	}
	
	
}
