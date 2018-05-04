package com.oneconnect.sme.foundation.generator.service;

import java.util.List;

import com.oneconnect.sme.foundation.generator.entity.GenerateRequest;
import com.oneconnect.sme.foundation.generator.entity.PropertiesRequest;
import com.oneconnect.sme.foundation.generator.entity.Table;

public interface IGenerateService {

	public List<Table> generate(GenerateRequest request);
	
	public String propertiesGenerate(PropertiesRequest request);

}
