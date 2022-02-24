package click.techlabs.pong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PongApplication {

	public static void main(String[] args) {
		SpringApplication.run(PongApplication.class, args);
	}

}
