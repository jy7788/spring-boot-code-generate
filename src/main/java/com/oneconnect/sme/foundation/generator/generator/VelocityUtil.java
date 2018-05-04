package com.oneconnect.sme.foundation.generator.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VelocityUtil {

	public static boolean export(String filePath, String fileName, Map<String, Object> context, String templateName) {

		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

		ve.init();

		Template t = ve.getTemplate(templateName, "UTF-8");
		VelocityContext ctx = new VelocityContext();

		if (null != context && !context.isEmpty()) {
			for (Entry<String, Object> row : context.entrySet()) {
				ctx.put(row.getKey(), row.getValue());
			}
		}

		Writer sw = null;
		try {
			File exportDir = new File(filePath);
			if (!exportDir.exists()) {
				exportDir.mkdirs();
			}
			File exportFile = new File(filePath + "" + fileName);
			if (exportFile.exists()) {
				exportFile.delete();
			}

			sw = new FileWriter(exportFile);
			t.merge(ctx, sw);
			sw.flush();

			logger.info("文件生成完毕:{}{}", filePath, fileName);

		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (sw != null) {
				try {
					sw.flush();
					sw.close();
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}

			}
		}

		return true;

	}

	private static final Logger logger = LoggerFactory.getLogger(VelocityUtil.class);

}
