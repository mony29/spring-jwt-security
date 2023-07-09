package com.example.loginwithjwt;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

// swagger configuration --- start ---
@SecurityScheme(
        name = "bearerAuth", // name = "basicAuth" for basic security
        type = SecuritySchemeType.HTTP,
        scheme = "bearer" , // can be set to anything,
        in = SecuritySchemeIn.HEADER // basic security non this
)
@OpenAPIDefinition(
        info = @Info(title = "Sample API", version = "v1", description = "This is description")
//        security = @SecurityRequirement(name = "basicAuth") // require all endpoint
        // when use in application it is applies all controller, but you can specify on any controller
)
// swagger configuration --- end ---

public class LoginWithJwtApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginWithJwtApplication.class, args);
    }

}
