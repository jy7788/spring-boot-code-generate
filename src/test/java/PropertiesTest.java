import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.oneconnect.sme.foundation.generator.PropertiesController;
import com.oneconnect.sme.foundation.generator.entity.GenerateRequest;
import com.oneconnect.sme.foundation.generator.entity.PropertiesRequest;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
public class PropertiesTest {
 @Autowired
 private PropertiesController propertiesController;
 
 private final Logger logger = LoggerFactory.getLogger(getClass());
    @Test
	public void testFind() {
		PropertiesRequest request = new PropertiesRequest();
		logger.info("生成开始");
		//包路径
		request.setExportPackage("com.oneconnect.sme");
		//生成文件路径
		request.setPagePath("D:\\git\\Customs\\customs-parent\\customs-backend\\src\\main\\java\\com\\oneconnect\\sme\\");
		//类名
		request.setTableName("MessageConstantBackend");
		//指定模板
		request.setExportTemplate("velocitytemplate/springboot/constant/PropertiesClassTemplate.vm");
		//错误提醒配置的properties文件路径
		request.setFilePath("D:/git/Customs/customs-parent/customs-foundation/src/main/resources/messages/foundation-message.properties");
		ResponseEntity<String> result = propertiesController.index(request);
		logger.info("生成结束 {}", result);
	}
}
