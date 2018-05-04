package com.oneconnect.sme.foundation.generator.entity;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Column {
	static final Map<String, String> javaTypeMap = new HashMap<String, String>();
	static final Map<String, String> myBatisTypeMap = new HashMap<String, String>();

	static {
		javaTypeMap.put("varchar", "String");
		javaTypeMap.put("text", "String");
		javaTypeMap.put("char", "String");
		javaTypeMap.put("bit", "Integer");
		javaTypeMap.put("int", "Integer");
		javaTypeMap.put("tinyint", "Integer");
		javaTypeMap.put("bigint", "Integer");
		javaTypeMap.put("date", "Date");
		javaTypeMap.put("datetime", "Date");
		javaTypeMap.put("timestamp", "Date");
		javaTypeMap.put("decimal", "BigDecimal");
		javaTypeMap.put("float", "Float");
		javaTypeMap.put("double", "Double");
		javaTypeMap.put("NUMBER", "Integer");
		javaTypeMap.put("VARCHAR2", "String");
		javaTypeMap.put("TIMESTAMP(6)", "Integer");
		javaTypeMap.put("DATE", "Date");
		javaTypeMap.put("CHAR", "String");

		myBatisTypeMap.put("text", "VARCHAR");
		myBatisTypeMap.put("varchar", "VARCHAR");
		myBatisTypeMap.put("char", "VARCHAR");
		myBatisTypeMap.put("int", "INTEGER");
		myBatisTypeMap.put("bit", "INTEGER");
		myBatisTypeMap.put("tinyint", "INTEGER");
		myBatisTypeMap.put("bigint", "INTEGER");
		myBatisTypeMap.put("date", "DATE");
		myBatisTypeMap.put("datetime", "TIMESTAMP");
		myBatisTypeMap.put("timestamp", "TIMESTAMP");
		myBatisTypeMap.put("decimal", "DECIMAL");
		myBatisTypeMap.put("float", "FLOAT");
		myBatisTypeMap.put("double", "DOUBLE");
	}

	public String getFieldNameHeadUpper() {
		return getFieldName().substring(0, 1).toUpperCase() + getFieldName().substring(1);
	}

	public String getFieldName() {
		if (columnName == null) {
			return "";
		}

		String[] split = columnName.split("_");
		String ret = "";
		int i = 0;
		for (String str : split) {

			if (str == null || "".equals(str.trim())) {
				continue;
			}

			if (i == 0) {
				ret = str.substring(0, 1).toLowerCase() + str.substring(1).toLowerCase();
			} else {
				ret += str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
			}

			i++;

		}

		return ret;
	}

	public String getJavaDataType() {
		return javaTypeMap.containsKey(this.getDataType()) ? javaTypeMap.get(this.getDataType()) : this.getDataType();
	}

	public String getMyBatisDataType() {
		return myBatisTypeMap.containsKey(this.getDataType()) ? myBatisTypeMap.get(this.getDataType())
				: this.getDataType();
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	private String columnName;

	private String columnComment;

	private String dataType;

	private String columnType;

}
