package com.montezano.provider.domain.error;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ExceptionResponse {

    private String errorCode;
    private String errorMessage;
}
