package com.oneconnect.sme.foundation.generator.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.oneconnect.sme.foundation.generator.entity.Column;

/**
public interface MysqlDelegatorMapper extends DBMapper {

	@Select(SELECT_TABLE)
	@Results({ @Result(property = "columnName", column = "COLUMN_NAME"),
			@Result(property = "columnComment", column = "COLUMN_COMMENT"),
			@Result(property = "dataType", column = "DATA_TYPE"),
			@Result(property = "columnType", column = "COLUMN_TYPE") })
	public List<Column> getTableColumns(@Param("tableName") String tableName, @Param("schema") String schema);

	static final String SELECT_TABLE = "SELECT COLUMN_NAME" //
			+ ",COLUMN_COMMENT" //
			+ ",DATA_TYPE"//
			+ ",COLUMN_TYPE  "//
			+ " FROM INFORMATION_SCHEMA.COLUMNS"//
			+ " WHERE TABLE_NAME = #{tableName}"//
			+ " and table_schema = #{schema}" //
			+ " and column_name not in ('sys_code') "//
			+ " ORDER BY ORDINAL_POSITION";
}
*/