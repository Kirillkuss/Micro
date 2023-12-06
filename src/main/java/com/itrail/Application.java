package com.itrail;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@OpenAPIDefinition(
    info = @Info(
            title = "Micro", description = "Micro"
    )
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
        log.info( "MICRO >>>> ");
    }
}