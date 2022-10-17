package com.sbsoft.grup.controller;

import com.sbsoft.grup.model.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ResponseBody
  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//  TODO: Catch all kinds of errors for now
  String employeeHandler(RuntimeException ex) {
    System.out.println(ex);
    return ex.getMessage();
  }
}
