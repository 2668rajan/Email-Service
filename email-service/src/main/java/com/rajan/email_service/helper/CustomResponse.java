package com.rajan.email_service.helper;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomResponse {

    private String message;
    private HttpStatus httpStatus;
    private boolean success=false;
}
