package com.oneconnect.sme.foundation.generator.mapper.impl;
  
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.oneconnect.sme.foundation.generator.entity.Column;
import com.oneconnect.sme.foundation.generator.mapper.DBMapper;
/**
 * 
 * oracle表字段获取
 * @author PC-07B85Y
 *
 */
public class OracleDelegatorMapperImpl implements DBMapper {
/**
 * asdfadsf
 * @param ds
 */
	public OracleDelegatorMapperImpl(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public List<Column> getTableColumns(String tableName, String schema) {
		/* test 去掉 sys_code 列 */
		String sql = "select a.column_name , b.comments , a.data_type"+ 
				" from user_tab_columns a , user_col_comments b"+
				" where a.COLUMN_NAME = b.COLUMN_NAME and "+
				" a.table_Name='"+tableName+"'  "+
				" and b.TABLE_NAME='"+tableName+"'"+
				" order by a.column_id";

		List<Column> columns = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Column column = new Column();
			column.setColumnName(rs.getString("COLUMN_NAME"));
			if(rs.getString("COMMENTS")==null) {
				column.setColumnComment("");
			}else {
				column.setColumnComment(rs.getString("COMMENTS"));
			}
			column.setColumnType("");//oracle没有这个字段，置空
			column.setDataType(rs.getString("DATA_TYPE"));
			return column;
		});

		return columns;
	}

	private JdbcTemplate jdbcTemplate;

}
