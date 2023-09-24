package com.michal.employeemanagment.exceptions;

public class UserNotFoundException extends RuntimeException{

  public UserNotFoundException(String message) {
    super(message);
  }
}
