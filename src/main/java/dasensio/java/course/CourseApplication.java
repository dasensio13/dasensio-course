package dasensio.java.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class CourseApplication {

	public static void main(final String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}
}
