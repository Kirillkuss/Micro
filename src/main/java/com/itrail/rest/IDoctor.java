package com.itrail.rest;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "1. Doctors", description = "Доктора:")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public interface IDoctor {

    @Get()
    @Operation( description = "Список всех докторов", summary = "Список всех докторов")
    HttpResponse<?> getAll();
    
    @Get("/{id}")
    @Operation( description = "Поиск доктора по ИД", summary = "Поиск доктора по ИД")
    HttpResponse<?> findById( Long id );
    
}
