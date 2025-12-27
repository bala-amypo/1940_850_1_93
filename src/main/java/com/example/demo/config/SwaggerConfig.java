package com.example.demo.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.*;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        SecurityScheme jwtScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER)
                .name("Authorization");

        SecurityRequirement securityRequirement =
                new SecurityRequirement().addList("bearerAuth");

        Server customServer = new Server()
                .url("https://9241.408procr.amypo.ai/")
                .description("Custom deployment server");

        return new OpenAPI()
                .info(new Info()
                        .title("Drug Interaction Checker API")
                        .description("API for checking drug interactions using active ingredients")
                        .version("1.0.0")
                )
                .servers(List.of(customServer))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", jwtScheme)
                )
                .addSecurityItem(securityRequirement);
    }
}
