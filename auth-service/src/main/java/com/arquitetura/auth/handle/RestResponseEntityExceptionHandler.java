package com.arquitetura.auth.handle;

import com.arquitetura.auth.util.ApiError;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NullPointerException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) throws JsonProcessingException {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), new ArrayList<>());
        String json = new ObjectMapper().writeValueAsString(apiError);
        return handleExceptionInternal(ex, json , new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

}
