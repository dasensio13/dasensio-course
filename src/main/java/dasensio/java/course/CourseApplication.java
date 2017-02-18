package dasensio.java.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dasensio.java.course.config.SecurityConfig;

@SpringBootApplication
public class CourseApplication {

	public static void main(final String[] args) {
		SpringApplication app = new SpringApplication(SecurityConfig.class, CourseApplication.class);
		app.run(args);
	}
}
