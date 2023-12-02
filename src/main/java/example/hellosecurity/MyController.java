package example.hellosecurity;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
public class MyController {
	MyService service;
	
	@GetMapping("/hello")
	public String hello() {
		return service.greeting();
	}
}
