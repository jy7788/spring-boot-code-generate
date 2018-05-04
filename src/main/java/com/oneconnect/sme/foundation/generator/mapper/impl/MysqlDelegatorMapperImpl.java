package com.oneconnect.sme.foundation.generator.mapper.impl;
  
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.oneconnect.sme.foundation.generator.entity.Column;
import com.oneconnect.sme.foundation.generator.mapper.DBMapper;
/**
 * 
 * @author PC-07B85Y
 *
 */
public class MysqlDelegatorMapperImpl implements DBMapper {
/**
 * asdfadsf
 * @param ds
 */
	public MysqlDelegatorMapperImpl(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public List<Column> getTableColumns(String tableName, String schema) {
		/* test 去掉 sys_code 列 */
		String sql = "SELECT COLUMN_NAME"//
				+ ",COLUMN_COMMENT"//
				+ ",DATA_TYPE"//
				+ ",COLUMN_TYPE"//
				+ " FROM INFORMATION_SCHEMA.COLUMNS "//
				+ " WHERE TABLE_NAME = '" + tableName + "'"//
				+ " and table_schema = '" + schema + "'"//
				+ "and column_name not in ('sys_code') ORDER BY ORDINAL_POSITION";

		List<Column> columns = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Column column = new Column();
			column.setColumnName(rs.getString("COLUMN_NAME"));
			column.setColumnComment(rs.getString("COLUMN_COMMENT"));
			column.setColumnType(rs.getString("COLUMN_TYPE"));
			column.setDataType(rs.getString("DATA_TYPE"));
			return column;
		});

		return columns;
	}

	private JdbcTemplate jdbcTemplate;

}
