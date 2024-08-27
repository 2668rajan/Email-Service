package com.rajan.email_service.helper;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

    private String from;

    private String content;
    private List<String> files;

    private String subject;
}
