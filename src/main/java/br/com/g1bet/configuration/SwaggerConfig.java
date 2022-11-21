package br.com.g1bet.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springG1BetOpenAPI (){
        return new OpenAPI()
                .info(new Info()
                        .title("G1Bet - API")
                        .description("API de Apostas G1Bet")
                        .version("v0.0.1")
                .license(new License()
                        .name("G1Bet")
                        .url("https://github.com/PI-DH-Grupo01"))
                .contact(new Contact()
                        .name("Contato G1Bet")
                        .url("https://github.com/PI-DH-Grupo01")))
                .externalDocs(new ExternalDocumentation()
                        .description("Github")
                        .url("https://github.com/PI-DH-Grupo01"));
    }

}
