package com.itrail.exception;

import io.micronaut.http.server.exceptions.ExceptionHandler;
import java.util.NoSuchElementException;
import javax.naming.AuthenticationException;
import com.itrail.responses.BaseError;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Produces
@Singleton
public class GlobalExceptionHandler  implements ExceptionHandler<Throwable,  HttpResponse<BaseError>> {

    @Override
    public HttpResponse<BaseError> handle( HttpRequest httpRequest, Throwable ex) {
        log.error("1.Request: " + httpRequest.toString() + " 2.Message: " + ex.getMessage() );
        if ( ex.getClass().equals( IllegalArgumentException.class ) ){
            return HttpResponse.badRequest( new BaseError( 400, ex.getMessage()));
        }
        if( ex.getClass().equals( NoSuchElementException.class) ){
            return HttpResponse.status( HttpStatus.NOT_FOUND).body( new BaseError( 404, ex.getMessage()));
        }
        if( ex.getClass().equals( AuthenticationException.class) ){
            return HttpResponse.status( HttpStatus.UNAUTHORIZED ).body( new BaseError( 401, ex.getMessage()));
        }
        return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).body( new BaseError( 500, ex.getMessage()));
    }
    
}
