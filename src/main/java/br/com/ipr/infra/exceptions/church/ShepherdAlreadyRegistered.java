package br.com.ipr.infra.exceptions.church;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ShepherdAlreadyRegistered extends RuntimeException {

  public ShepherdAlreadyRegistered() {
    super("Shepherd already registered in a church");
  }

  public ShepherdAlreadyRegistered(String message) {
    super(message);
  }
}
