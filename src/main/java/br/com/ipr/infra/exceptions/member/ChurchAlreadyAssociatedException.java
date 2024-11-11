package br.com.ipr.infra.exceptions.member;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ChurchAlreadyAssociatedException extends RuntimeException {
  public ChurchAlreadyAssociatedException(String message) {
    super(message);
  }

  public ChurchAlreadyAssociatedException() {}
}
