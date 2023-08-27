package com.example.money.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(
        title = "Crypt money Api",
        description = "My app", version = "1.0.0",
        contact = @Contact(
                name = "Siargei",
                email = "avatarsim777@ganil.com",
                url = "https://github.com/SERGIOGIT777"
        )
))
public class OpenApiConfig {
}
