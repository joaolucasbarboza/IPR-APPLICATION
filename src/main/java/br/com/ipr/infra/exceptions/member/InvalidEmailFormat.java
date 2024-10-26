package br.com.ipr.infra.exceptions.member;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InvalidEmailFormat extends RuntimeException {

  public InvalidEmailFormat(String message) {
    super(message);
  }

  public InvalidEmailFormat() {
    super("Invalid email format");
  }
}
