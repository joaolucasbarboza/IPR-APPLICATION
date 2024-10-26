package br.com.ipr.infra.exceptions.member;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MemberAlreadyExist extends RuntimeException {

  public MemberAlreadyExist(String message) {
    super(message);
  }

  public MemberAlreadyExist() {
    super("Member already exists");
  }
}
