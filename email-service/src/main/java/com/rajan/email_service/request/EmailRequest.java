package com.rajan.email_service.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailRequest {

    private String to;
    private String subject;
    private String message;
}
