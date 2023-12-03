package example.hellosecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(EnvironmentVariablesConfigTest.class)
public class HelloSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSecurityApplication.class, args);
	}

}
