package design.boilerplate.springboot.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 
 * @author taha
 */
@RestController
public class StartupController {
	@GetMapping("/startup")
	public ResponseEntity<String> sayHello() {

		return ResponseEntity.ok("Hello Spring Boot Boilerplate");
	}

}
