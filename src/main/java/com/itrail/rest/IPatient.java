package com.itrail.rest;

import javax.validation.Valid;
import com.itrail.models.Patient;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "2. Patient", description = "Пациенты:")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public interface IPatient {

    @Get()
    @Operation( description = "Список всех пациентов", summary = "Список всех пациентов")
    public HttpResponse<?> getAllPatients();


    @Post( value = "/add")
    @Operation( description = "Добавить пациента", summary = "Добавить пациента")
    public HttpResponse<?> addPatient( @Valid @Body() Patient patient, Long idDocument);

    @Get(value = "/find/{word}")
    @Operation( description = "Поиск пациента по ФИО или номеру телефона", summary = "Поиск пациента по ФИО или номеру телефона")
    public HttpResponse<?> findByWord( @Parameter()  String word );

    
    
}
