package org.adaitw.tp_api_java_coach.advice_validation;

import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestResponse<T> {

    private Timestamp timestamp;
    private String data;
    private Integer responseCode;
    private String status;

}
