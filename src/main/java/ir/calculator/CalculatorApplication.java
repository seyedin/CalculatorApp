package ir.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CalculatorApplication {
    private static final Logger log = LoggerFactory.getLogger(CalculatorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);


        log.info("\n The Spring Boot Application is now up and running on port 8080! ");
        log.info("\n Swagger OpenAPI documentation is available at: http://localhost:8080/swagger-ui.html");
        log.info("\n Enjoy exploring your API! ");
    }

}
