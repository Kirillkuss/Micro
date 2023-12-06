package com.itrail.controllers;

import com.itrail.models.Doctor;
import com.itrail.models.Document;
import com.itrail.responses.BaseError;
import com.itrail.rest.IDocument;
import com.itrail.services.DocumentService;
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
@Controller("documents")
@RequiredArgsConstructor
@ApiResponses(value = {
    @ApiResponse( responseCode = "200", description = "Успешно",        content = { @Content( array = @ArraySchema(schema = @Schema( implementation = Doctor.class))) }),
    @ApiResponse( responseCode = "400", description = "Плохой запрос",  content = { @Content( array = @ArraySchema(schema = @Schema( implementation = BaseError.class ))) }),
    @ApiResponse( responseCode = "500", description = "Ошибка сервера", content = { @Content( array = @ArraySchema(schema = @Schema( implementation = BaseError.class ))) })
    })
public class DocumentController implements IDocument {

    private final DocumentService documentService;

    @Override
    public HttpResponse<?> getAllDocuments() {  
        return HttpResponse.status( HttpStatus.OK ).body( documentService.findAll() );
    }

    @Override
    public HttpResponse<?> addDocument( Document document) {
         return HttpResponse.status( HttpStatus.OK ).body( documentService.addDocument( document ));
    }

    @Override
    public HttpResponse<?> findById(Long id) {
         return HttpResponse.status( HttpStatus.OK ).body( documentService.findById( id ));
    }

}
