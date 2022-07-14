package com.transport.stenlogistics.advice;

import com.transport.stenlogistics.exception.GoodsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/***
 * Controller Advice is used to do Global Exception Handling. It is an interceptor to intercept any
 * Exception Relevant with a Specific class mentioned.
 */

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(GoodsException.class)
    public final ResponseEntity<GoodsException> handleException(GoodsException exception,WebRequest webRequest){
        GoodsException response = new GoodsException(exception.getDate(),exception.getErrorCode(),exception.getErrorMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(response,new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
