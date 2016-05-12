package in.ankushs.webbrowscap4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootBrowscap4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBrowscap4jApplication.class, args);
	}
}
