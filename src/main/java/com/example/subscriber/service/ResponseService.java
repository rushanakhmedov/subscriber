package com.example.subscriber.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.Map;

@Service
public class ResponseService {

    public ResponseService() {
    }

    public Map<String, String> convertErrors(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        for (ObjectError errorObject: bindingResult.getAllErrors()) {
            FieldError fieldError = (FieldError) errorObject;
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return errors;
    }
}
