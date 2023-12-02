package example.hellosecurity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import uk.org.webcompere.systemstubs.environment.EnvironmentVariables;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@ExtendWith(SpringExtension.class)
@ExtendWith(SystemStubsExtension.class)
class HelloSecurityApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@SystemStub
	private EnvironmentVariables environment = new EnvironmentVariables("MY VARIABLE", "is set");

	@Test
	void testEnvironmentVariables() {
		assertThat(System.getenv("MY VARIABLE")).isEqualTo("is set");
	}

	@Test
	void testHello() {
		webTestClient
				.mutateWith(SecurityMockServerConfigurers.mockJwt())
				.get()
				.uri("/hello")
//				.header("Authorization", "Bearer eyJraWQiOiIxT2o1dFFhbVFpQU9OUXAxV0dLUkFYQ01iSmtzeXYxK05GcWZGZVErU1NFPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI2Z3Q3azQzc2YxN3JmbnFmbzNyMnJrMGozNSIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiZmVycmFtZW50YXNcL2VjbyIsImF1dGhfdGltZSI6MTcwMTUzODE2NCwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLnNhLWVhc3QtMS5hbWF6b25hd3MuY29tXC9zYS1lYXN0LTFfdWQxNkRJY0J4IiwiZXhwIjoxNzAxNTQxNzY0LCJpYXQiOjE3MDE1MzgxNjQsInZlcnNpb24iOjIsImp0aSI6IjQxZTJkNTE1LTBhYzItNGZjMC05ZTRhLWUxYzZiODNjNjZhMCIsImNsaWVudF9pZCI6IjZndDdrNDNzZjE3cmZucWZvM3IycmswajM1In0.Y87cex2KyIZeI5e7YAGBusoRUsWWaqgW7SqTX8jClHhyggO9O3Z1wSXVz89U3RO2xJbvYUeQsQeRwlZvOhGzuJ25wqjOl6KTQcCfxlgA6NqkDfFJD52k2jSRtbMExXyfqBxfbMRrWg4K7j0bKd27roFnGdQtK-YpU6-_FbIKmWSIIXYd6H-ub9PzEt3tcymlz17rj-_axcYQgvhY2qRk_zp2gdV9l7eJtM8mTTgdP6jOSQWZtm9bdJZDzbvaYvcC2DcERUbcJtf4vqeQisirBvU46VEMjM6F8qLJBjz3WfPC8aJxsPEwChvUog_lzrP2uUY-KkJR4Sshp8haNY1dGg")
				.exchange()
				.expectStatus()
				.isOk();
	}

}
