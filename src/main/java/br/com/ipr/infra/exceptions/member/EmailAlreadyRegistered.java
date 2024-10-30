package br.com.ipr.infra.exceptions.member;

public class EmailAlreadyRegistered extends RuntimeException {
  public EmailAlreadyRegistered(String message) {
    super(message);
  }
}
