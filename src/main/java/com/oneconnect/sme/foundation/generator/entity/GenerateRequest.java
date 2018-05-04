package com.oneconnect.sme.foundation.generator.entity;

import java.io.Serializable;

public class GenerateRequest implements Serializable {

	private static final long serialVersionUID = 370430819306023255L;

	public String[] getExportTables() {
		return exportTables;
	}

	public GenerateRequest setExportTables(String[] exportTables) {
		this.exportTables = exportTables;
		return this;
	}

	public String getExportPath() {
		return exportPath;
	}

	public GenerateRequest setExportPath(String exportPath) {
		this.exportPath = exportPath;
		return this;
	}

	public String getExportPackage() {
		return exportPackage;
	}

	public GenerateRequest setExportPackage(String exportPackage) {
		this.exportPackage = exportPackage;
		return this;
	}

	public String getExportSchema() {
		return exportSchema;
	}

	public GenerateRequest setExportSchema(String exportSchema) {
		this.exportSchema = exportSchema;
		return this;
	}

	public String getExportTemplate() {
		return exportTemplate;
	}

	public GenerateRequest setExportTemplate(String exportTemplate) {
		this.exportTemplate = exportTemplate;
		return this;
	}

	public String getDBType() {
		return DBType;
	}

	public GenerateRequest setDBType(String DBType) {
		this.DBType = DBType;
		return this;
	}

	public String getDBUrl() {
		return DBUrl;
	}

	public GenerateRequest setDBUrl(String dBUrl) {
		DBUrl = dBUrl;
		return this;
	}

	public String getDBUserName() {
		return DBUserName;
	}

	public GenerateRequest setDBUserName(String dBUserName) {
		DBUserName = dBUserName;
		return this;
	}

	public String getDBPassword() {
		return DBPassword;
	}

	public GenerateRequest setDBPassword(String dBPassword) {
		DBPassword = dBPassword;
		return this;
	}

	public String getDBDriver() {
		return DBDriver;
	}

	public GenerateRequest setDBDriver(String dBDriver) {
		DBDriver = dBDriver;
		return this;
	}

	private String DBType;
	private String DBUrl;
	private String DBUserName;
	private String DBPassword;
	private String DBDriver;

	private String exportSchema;
	private String[] exportTables;
	private String exportPackage;
	private String exportPath;
	private String exportTemplate;

}
