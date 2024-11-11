package br.com.ipr.infra.exceptions.member;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmailAlreadyRegistered extends RuntimeException {
  public EmailAlreadyRegistered(String message) {
    super(message);
  }

  public EmailAlreadyRegistered() {}
}
