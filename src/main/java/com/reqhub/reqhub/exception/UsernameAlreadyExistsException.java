package com.reqhub.reqhub.exception;

  public class UsernameAlreadyExistsException extends RuntimeException {
  public UsernameAlreadyExistsException(String massage) {
	  super(massage);
  }
}
