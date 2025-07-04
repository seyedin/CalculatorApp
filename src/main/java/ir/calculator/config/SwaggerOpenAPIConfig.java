package ir.calculator.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerOpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Rest API Sanaz")
                        .version("1.0.0")
                        .description("API for testing purposes")
                        .contact(new Contact()
                                .name("Sanaz")
                                .email("sanaz.seyedin@yahoo.com")
                        )
                );
    }
}
