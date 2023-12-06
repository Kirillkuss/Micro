package com.itrail.responses;

import java.io.Serializable;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Serdeable
public class BaseError implements Serializable {

    private int code = 0;
    private String message = "error";
    
}
