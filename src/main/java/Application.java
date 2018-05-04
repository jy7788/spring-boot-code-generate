
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@ConfigurationProperties
@ComponentScan(basePackages = "com.oneconnect.sme.foundation.generator")
public class Application implements CommandLineRunner {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... arg0) throws Exception {

		logger.info("代码生成器启动");
	}

	@Value("${app.name}")
	private String appName;

	@Value("${app.propfiles}")
	private String messagePropFiles;

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
}
