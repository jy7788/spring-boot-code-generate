package com.oneconnect.sme.foundation.generator.generator.impl;

import java.util.HashMap;
import java.util.Map;

import com.oneconnect.sme.foundation.generator.entity.Table;
import com.oneconnect.sme.foundation.generator.generator.ICodeGenerator;
import com.oneconnect.sme.foundation.generator.generator.VelocityUtil;

public class DynaSqlProviderFileGenerator implements ICodeGenerator {

	@Override
	public String fire(Table table) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("_table", table);

		VelocityUtil.export(table.getExportPath() + "mapper\\provider\\", table.getClassName() + "DynaSqlProvider.java", params, getVelocityFileName());

		return null;

	}

	@Override
	public String getVelocityFileName() {

		return tempalte + "DynaSqlProviderClassTemplate.vm";
	}

	@Override
	public ICodeGenerator setTemplate(String template) {

		this.tempalte = template;

		return this;

	}

	private String tempalte = null;

}
