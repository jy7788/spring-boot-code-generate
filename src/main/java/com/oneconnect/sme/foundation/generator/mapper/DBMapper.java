package com.oneconnect.sme.foundation.generator.mapper;

import java.util.List;

import com.oneconnect.sme.foundation.generator.entity.Column;

public interface DBMapper {

	public List<Column> getTableColumns(String tableName, String schema);

}
