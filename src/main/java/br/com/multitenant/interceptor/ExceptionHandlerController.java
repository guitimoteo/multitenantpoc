package br.com.multitenant.interceptor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class})
    private ResponseEntity illegalExceptionHandler(IllegalArgumentException e, WebRequest request) throws Exception {
        return handleException(e, request);
    }

    @ExceptionHandler(value = {ResponseStatusException.class})
    private ResponseEntity notFoundExceptionHandler(IllegalArgumentException e, WebRequest request) throws Exception {
        return handleException(e, request);
    }
}