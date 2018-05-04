package com.oneconnect.sme.foundation.generator.entity;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Table {

	public String getPackageName(String sufix) {
		if (packageName != null && packageName.trim().length() > 0) {
			return "package " + packageName.trim().replaceAll(";", "") + (sufix != null ? sufix : "") + ";\r\n";
		}

		return "";
	}

	public String getClassName() {
		if (tableName == null) {
			return "";
		}

		String[] split = tableName.split("_");
		String ret = "";

		int i = 0;

		for (String str : split) {
			if (str == null || "".equals(str.trim())) {
				continue;
			}

			if (i == 0 && "t".equals(str.toLowerCase())) {
				i++;
				continue;
			}

			ret += str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
			i++;
		}

		return ret;
	}

	public String getClassNameHeadLower() {
		return getClassName().substring(0, 1).toLowerCase() + getClassName().substring(1);
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getExportPath() {
		return exportPath;
	}

	public void setExportPath(String exportPath) {
		this.exportPath = exportPath;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	private String template;

	private List<Column> columns;

	private String tableName;

	private String packageName;

	private String exportPath;

	private String schema;
}
