package org.adaitw.tp_api_java_coach.exception;

import org.adaitw.tp_api_java_coach.advice_validation.RestResponse;
import org.adaitw.tp_api_java_coach.advice_validation.Time;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionGlobalResponse {

    RestResponse result;

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RestResponse> runtimeException(RuntimeException e) {
        result = new RestResponse(Time.getTime(), "[Exception Response] - Exception: " + e.getMessage(), 500, "Error");
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestResponse> exception(Exception e) {
        result = new RestResponse(Time.getTime(), "[Exception Response] - Exception: " + e.getMessage(), 500, "Error");
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
