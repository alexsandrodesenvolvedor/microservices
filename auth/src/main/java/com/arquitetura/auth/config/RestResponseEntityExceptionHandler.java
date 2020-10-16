/*
package com.arquitetura.auth.config;

import com.arquitetura.auth.util.ApiError;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.converters.wrappers.CodecWrappers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {BadCredentialsException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) throws JsonProcessingException {
        ApiError apiError = new ApiError(HttpStatus.FORBIDDEN., ex.getLocalizedMessage(), new ArrayList<>());
        String json = new ObjectMapper().writeValueAsString(apiError);
        return handleExceptionInternal(ex, json , new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

}*/
