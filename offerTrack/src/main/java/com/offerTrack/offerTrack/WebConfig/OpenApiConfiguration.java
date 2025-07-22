package com.offerTrack.offerTrack.WebConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI defineOpenApi() {
        Server localServer = new Server()
                .url("http://localhost:8080")
                .description("Serveur local de développement");

        Info info = new Info()
                .title("OfferTrack API")
                .version("1.0")
                .description("API pour visualiser les KPIs des entreprises dans le contexte des appels d’offres")
                .contact(new Contact()
                        .name("Équipe OfferTrack"));

        return new OpenAPI()
                .info(info)
                .servers(List.of(localServer));
    }
}
