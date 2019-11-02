package springbootrestapi.testapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TestEmployeeApplication extends SpringBootServletInitializer{
	public static void main(String []args){
		SpringApplication.run(TestEmployeeApplication.class, args);
	}
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(TestEmployeeApplication.class);
	}
}
