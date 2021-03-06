package hoon.schooldb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SchooldbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchooldbApplication.class, args);
    }

}
