package m2.eservices.alloetudiant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootApplication
@EnableMongoAuditing
public class AlloetudiantApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlloetudiantApplication.class, args);
	}
}
