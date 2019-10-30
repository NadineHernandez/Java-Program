package com.company.U1M4SummativeHernandezNadine.controller;


import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
//produces tells us return type
@RequestMapping(produces = "application/vnd.error+json")
public class M4SummativeExceptionHandler {
    //we're only going to handle illegal argument exception
    @ExceptionHandler(value = {IllegalArgumentException.class})
    //422 response status
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    //return a vndError
    public ResponseEntity<VndErrors> outOfRangeException
    (IllegalArgumentException e, WebRequest request) {
        //create a new error object
        VndErrors error = new VndErrors(request.toString(), e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new
                ResponseEntity<>
                //error message and json goes out with status 422
                (error, HttpStatus.BAD_REQUEST);
        //return error
        return responseEntity;
    }
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<VndErrors> questionValidationError
            (MethodArgumentNotValidException e, WebRequest request){
        //Binding result holds the validation result()
        BindingResult result= e.getBindingResult();
        //validation errors are stared in FieldError objects
        List<FieldError> fieldErrors = result.getFieldErrors();

        //Translate the Field Errors to VndErrors
        List<VndErrors.VndError> vndErrorList = new ArrayList<>();

        //iterate through list of all errors and put them in vnd
        for(FieldError fieldError : fieldErrors){
            VndErrors.VndError vndError = new VndErrors.VndError(request.toString() ,
                    fieldError.getDefaultMessage());
        }
        //Wrap all of the VndError objects in VndErrors object
        VndErrors vndErrors = new VndErrors(vndErrorList);
        //Create and return the ResponseEntity

        ResponseEntity<VndErrors> responseEntity =
                new ResponseEntity<>(vndErrors, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
}