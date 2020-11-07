package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler({BusinessException.class,
            MethodArgumentNotValidException.class})
    public ResponseEntity<Map> handleRegisterException(Exception ex) {
        Map<String,Object> responseData = new HashMap<>();
        if(ex instanceof BusinessException){
            BusinessException businessException = (BusinessException)ex;
            responseData.put("errorCode",businessException.getErrorCode());
            responseData.put("errorMsg",businessException.getErrorMsg());
        }else{
            responseData.put("errorCode", EmBusinessError.UNKNOWN_ERROR.getErrorCode());
            responseData.put("errorMsg",EmBusinessError.UNKNOWN_ERROR.getErrorMsg());
        }
        return ResponseEntity.status(400).body(responseData);
    }

}
