import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.oneconnect.sme.foundation.generator.IndexController;
import com.oneconnect.sme.foundation.generator.entity.GenerateRequest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
public class GenerateTest {

	@Autowired
	private IndexController indexController;

	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void testFind() {

		GenerateRequest request = new GenerateRequest();

		logger.info("生成开始");

		request.setDBType("oracle");
		request.setDBDriver("oracle.jdbc.driver.OracleDriver");
		request.setDBUrl("jdbc:oracle:thin:@XXX:1521:orcl");
		request.setDBUserName("XXX");
		request.setDBPassword("123456");

		String[] tables = { "K_DA_UPLOAD_INFO","K_DA_UPLOAD_LIST","K_DA_UPLOAD_ZIP_LIST"};

		request.setExportSchema("world");
		request.setExportPackage("com.oneconnect.sme.filetransfer");
		request.setExportPath("E:\\tmp\\gentest\\");
		//request.setExportPath("D:\\git\\Customs\\customs-parent\\customs-backend\\src\\main\\java\\com\\oneconnect\\sme\\gentest\\");
		request.setExportTables(tables);
		request.setExportTemplate("velocitytemplate/springboot/customs/");

		ResponseEntity<String> result = indexController.index(request);

		logger.info("生成结束 {}", result);
	}

}