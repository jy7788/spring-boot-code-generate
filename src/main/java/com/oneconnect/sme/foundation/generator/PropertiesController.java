package com.oneconnect.sme.foundation.generator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oneconnect.sme.foundation.generator.entity.PropertiesRequest;
import com.oneconnect.sme.foundation.generator.service.IGenerateService;

@RestController
public class PropertiesController {
	
	@RequestMapping(value = "/properties", method = RequestMethod.POST)
	public ResponseEntity<String> index(@RequestBody PropertiesRequest request) {
		 service.propertiesGenerate(request);
		return ResponseEntity.ok("success");
	}

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IGenerateService service;
}
