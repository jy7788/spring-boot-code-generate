package com.oneconnect.sme.foundation.generator.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.pool.DruidDataSource;
import com.oneconnect.sme.foundation.generator.entity.GenerateRequest;
import com.oneconnect.sme.foundation.generator.entity.PropertiesRequest;
import com.oneconnect.sme.foundation.generator.entity.Table;
import com.oneconnect.sme.foundation.generator.generator.GenForeman;
import com.oneconnect.sme.foundation.generator.mapper.DBMapper;
//import com.oneconnect.sme.foundation.generator.mapper.MysqlDelegatorMapper;
import com.oneconnect.sme.foundation.generator.mapper.impl.MysqlDelegatorMapperImpl;
import com.oneconnect.sme.foundation.generator.mapper.impl.OracleDelegatorMapperImpl;
import com.oneconnect.sme.foundation.generator.service.IGenerateService;
import com.oneconnect.sme.foundation.generator.entity.Column;
@Service
public class GenerateServiceImpl implements IGenerateService {

	@Override
	public List<Table> generate(GenerateRequest request) {

		if (request.getExportTables() != null && request.getExportTables().length < 1)
			return null;

		List<Table> ret = new ArrayList<Table>(request.getExportTables().length);

		for (String tableName : request.getExportTables()) {

			Table table = new Table();
			table.setTableName(tableName);
			table.setExportPath(request.getExportPath());
			table.setPackageName(request.getExportPackage());
			table.setSchema(request.getExportSchema());
			table.setTemplate(request.getExportTemplate());
			ret.add(table);

		}

		ret.forEach(t -> {
			appendColumns(request, t);
			foreman.fireAll(t);

		});

		return ret;
	}

	private void appendColumns(GenerateRequest request, Table table) {
		table.setColumns(getMapper(request).getTableColumns(table.getTableName(), table.getSchema()));
	}

	private DBMapper getMapper(GenerateRequest request) {

		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(request.getDBDriver());
		ds.setUrl(request.getDBUrl());
		ds.setUsername(request.getDBUserName());
		ds.setPassword(request.getDBPassword());

		switch (request.getDBType()) {
		case "mysql":

			return new MysqlDelegatorMapperImpl(ds);
		case "oracle":
			return new OracleDelegatorMapperImpl(ds);
		default:
			return null;
		}

	}
	
	@Override
	public String propertiesGenerate(PropertiesRequest request) {
		Table table = new Table();
		table.setTableName(request.getTableName());
		table.setExportPath(request.getPagePath());
		table.setPackageName(request.getExportPackage());
		table.setTemplate(request.getExportTemplate());
		table.setColumns(getColumnList(request.getFilePath()));
		foreman.fireAll(table);
		return "成功";
	}
    
	private static List<Column> getColumnList(String filePath){
		     Properties properties = new Properties();
		     // 使用InPutStream流读取properties文件
		     BufferedReader bufferedReader;
		     List<Column> columnList = new ArrayList<Column>();
		     try {
				bufferedReader = new BufferedReader(new FileReader(filePath));
				properties.load(bufferedReader);
		        Enumeration enum1 = properties.propertyNames();//得到配置文件的名字
		        StringBuffer str = new StringBuffer();
		        while(enum1.hasMoreElements()) {
		              String strKey = (String) enum1.nextElement();
		              String strValue = properties.getProperty(strKey);
		              Column column = new Column();
		              column.setColumnName(strKey);
		              column.setDataType("String");
		              column.setColumnComment(strValue);
		              column.setDataType("");
		              columnList.add(column);
		        }
			} catch (Exception e) {
				e.printStackTrace();
			}
	        return columnList;
	}

	@Autowired
	private GenForeman foreman;

	// @Resource(type = MysqlDelegatorMapper.class)
	// private DBMapper mysqlDelegator;

}
