package com.itrail.rest;

import com.itrail.models.Document;
import com.itrail.responses.BaseError;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "3. Documents", description = "Документ документ")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public interface IDocument {

    @Get()
    @Operation( description = "Список всех документов", summary = "Список всех документов")
    public HttpResponse<?> getAllDocuments();

    @Post(value = "/add")
    @Operation( description = "Добавить документ", summary = "Добавить документ")
    public HttpResponse<?> addDocument( @Body Document document );

    @Get("/{id}")
    @Operation( description = "Найти документ", summary = "Найти документ")
    public HttpResponse<?> findById( Long id ) ;
    
}
