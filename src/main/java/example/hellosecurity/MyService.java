package example.hellosecurity;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("static-method")
@AllArgsConstructor
public class MyService {

	@Autowired
	EnvironmentVariablesConfigTest environmentVariablesConfigTest;

//	@PreAuthorize("authentication.name == 'alice' or authentication.name == 'user'")
	public String greeting() {
		System.out.println(environmentVariablesConfigTest.getMyVar());
		return "Hello !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
	}
}
