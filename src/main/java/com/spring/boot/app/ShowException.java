package com.spring.boot.app;

import com.spring.boot.app.ErrorMessage;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ErrorMessages;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.jws.WebResult;
import java.util.Date;

@ControllerAdvice
public class ShowException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object>  UserException(Exception ex, WebRequest request) {
       String errorDesc= ex.getLocalizedMessage();
       if( errorDesc== null) errorDesc = ex.toString();
        ErrorMessage errorMessage= new ErrorMessage(new Date(), errorDesc) {
        };
       return new ResponseEntity<>(
               errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR
       );
    }
}
