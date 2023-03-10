package jwt.opa.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JwtOpaPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtOpaPocApplication.class, args);
	}

}
