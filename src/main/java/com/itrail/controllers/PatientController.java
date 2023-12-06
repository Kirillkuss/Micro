package com.itrail.controllers;

import com.itrail.models.Patient;
import com.itrail.responses.BaseError;
import com.itrail.rest.IPatient;
import com.itrail.services.PatientService;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@Validated
@Controller("patients")
@RequiredArgsConstructor
@ApiResponses(value = {
        @ApiResponse( responseCode = "200", description = "Успешно",        content = { @Content(array = @ArraySchema(schema = @Schema( implementation = Patient.class ))) }),
        @ApiResponse( responseCode = "400", description = "Плохой запрос",  content = { @Content( array = @ArraySchema(schema = @Schema( implementation = BaseError.class ))) }),
        @ApiResponse( responseCode = "500", description = "Ошибка сервера", content = { @Content( array = @ArraySchema(schema = @Schema( implementation = BaseError.class ))) })
    })
public class PatientController implements IPatient {

    private final PatientService patientService;

    @Override
    public HttpResponse<?> getAllPatients() {
        return HttpResponse.status( HttpStatus.OK ).body( patientService.findAll() );
    }

    @Override
    public HttpResponse<?> addPatient(Patient patient, Long idDocument) {
        return HttpResponse.status( HttpStatus.OK ).body( patientService.addPatient( patient, idDocument ));
    }

    @Override
    public HttpResponse<?> findByWord(String word) {
        return HttpResponse.status( HttpStatus.OK ).body( patientService.findByFIO( word ));
    }

}
