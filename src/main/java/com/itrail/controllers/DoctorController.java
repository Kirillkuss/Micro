package com.itrail.controllers;

import com.itrail.models.Document;
import com.itrail.responses.BaseError;
import com.itrail.rest.IDoctor;
import com.itrail.services.DoctorService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@Validated
@Controller("/doctors")
@RequiredArgsConstructor
@ApiResponses(value = {
    @ApiResponse( responseCode = "200", description = "Успешно",        content = { @Content( array = @ArraySchema(schema = @Schema( implementation = Document.class))) }),
    @ApiResponse( responseCode = "400", description = "Плохой запрос",  content = { @Content( array = @ArraySchema(schema = @Schema( implementation = BaseError.class))) }),
    @ApiResponse( responseCode = "500", description = "Ошибка сервера", content = { @Content( array = @ArraySchema(schema = @Schema( implementation = BaseError.class))) })
})
public class DoctorController implements IDoctor {

    private final DoctorService doctorService;
    @Override
    public HttpResponse<?> getAll() {
        return HttpResponse.status(HttpStatus.OK)
                           .body( doctorService.findAll());
    }
    @Override
    public HttpResponse<?> findById(Long id) {
        return HttpResponse.status(HttpStatus.OK)
                           .body( doctorService.findById( id ));
    }
}