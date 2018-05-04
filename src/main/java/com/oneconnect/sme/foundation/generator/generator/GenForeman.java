package com.oneconnect.sme.foundation.generator.generator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.oneconnect.sme.foundation.generator.entity.Table;
import com.oneconnect.sme.foundation.generator.generator.impl.ControllerFileGenerator;
import com.oneconnect.sme.foundation.generator.generator.impl.DynaSqlProviderFileGenerator;
import com.oneconnect.sme.foundation.generator.generator.impl.EntityFileGenerator;
import com.oneconnect.sme.foundation.generator.generator.impl.MapperFileGenerator;
import com.oneconnect.sme.foundation.generator.generator.impl.PropertiesClassGenerator;
import com.oneconnect.sme.foundation.generator.generator.impl.ServiceFileGenerator;
import com.oneconnect.sme.foundation.generator.generator.impl.ServiceImplFileGenerator;

@Service
public class GenForeman {

	public void fireAll(Table table) {
		initTemplate(table.getTemplate()).forEach(t -> t.fire(table));
	}

	private List<ICodeGenerator> initTemplate(String genTemplate) {
		List<ICodeGenerator> generator = null;
		switch (genTemplate) {

		case "velocitytemplate/springboot/customs/":
			generator = initCustomsTemplate(genTemplate);
			break;
			
		case "velocitytemplate/springboot/constant/PropertiesClassTemplate.vm":
			generator = initConstantTemplate(genTemplate);
			break;
			
		default:
			generator = new ArrayList<ICodeGenerator>();
		}

		return generator;
	}

	private List<ICodeGenerator> initCustomsTemplate(String genTemplate) {

		List<ICodeGenerator> generator = new ArrayList<ICodeGenerator>();
		
		generator.add(new EntityFileGenerator().setTemplate(genTemplate));
		generator.add(new MapperFileGenerator().setTemplate(genTemplate));
		generator.add(new DynaSqlProviderFileGenerator().setTemplate(genTemplate));
		generator.add(new ServiceFileGenerator().setTemplate(genTemplate));
		generator.add(new ServiceImplFileGenerator().setTemplate(genTemplate));
		generator.add(new ControllerFileGenerator().setTemplate(genTemplate));

		return generator;
	}

	private List<ICodeGenerator> initConstantTemplate(String genTemplate) {
		List<ICodeGenerator> generator = new ArrayList<ICodeGenerator>();
		generator.add(new PropertiesClassGenerator().setTemplate(genTemplate));
		return generator;
	}
}
