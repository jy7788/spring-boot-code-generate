package com.oneconnect.sme.foundation.generator.generator;

import com.oneconnect.sme.foundation.generator.entity.Table;

public interface ICodeGenerator {

	ICodeGenerator setTemplate(String template);

	String fire(Table table);

	String getVelocityFileName();
}
