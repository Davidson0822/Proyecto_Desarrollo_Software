package edu.itm.SistemaDeInventario.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentationConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new io.swagger.v3.oas.models.info.Info()
                                .title("API de Sistema de inventario")
                                .version("1.0")
                                .description("Esta API seria la utilizada por el sistema")
                                .contact(new Contact().name("Juan Camilo Buritica Patiño").email("juanburitica1129428@correo.itm.edu.co"))
                                .contact(new Contact().name("Juan Camilo Orozco Blandon").email("juanorozco321265@correo.itm.edu.co"))
                                .contact(new Contact().name("Davidson Osorio Noreña").email("davidsonosorio1129975@correo.itm.edu.co"))
                                .contact(new Contact().name("Esteban Jimenez Guerra").email("estebanjimenez1133418@correo.itm.edu.co")));

    }
}