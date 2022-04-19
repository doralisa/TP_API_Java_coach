package org.adaitw.tp_api_java_coach.advice_validation;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RestFieldError {

    private String field;
    private String message;

}
