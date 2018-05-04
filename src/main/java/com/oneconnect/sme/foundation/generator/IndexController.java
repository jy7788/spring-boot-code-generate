package com.oneconnect.sme.foundation.generator;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oneconnect.sme.foundation.generator.entity.GenerateRequest;
import com.oneconnect.sme.foundation.generator.entity.Table;
import com.oneconnect.sme.foundation.generator.service.IGenerateService;

@RestController
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<String> index(@RequestBody GenerateRequest request) {

		List<Table> tables = service.generate(request);

		logger.info(" table generated. {}", tables);

		return ResponseEntity.ok("success");

	}

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IGenerateService service;
}
