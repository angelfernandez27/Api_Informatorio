package com.informatorio.API.config;

import com.informatorio.API.exception.ApiError;
import com.informatorio.API.exception.ApiException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class apiResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                               HttpStatus status, WebRequest request) {
        ApiError error = new ApiError();
        error.setStatus(status);
        error.setMessage(ex.getMessage());
       //error.setCantidadDeErrores(ex.getErrorCount());
        return new ResponseEntity<Object>(error, HttpStatus.I_AM_A_TEAPOT);
    }
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Object> handleMethodDataIntegrityViolationException(Exception e, WebRequest request){
        ApiError error=new ApiError();
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setMessage(e.getMessage());
        return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);
    }
}
