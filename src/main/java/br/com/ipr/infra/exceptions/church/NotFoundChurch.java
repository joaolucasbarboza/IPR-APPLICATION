package br.com.ipr.infra.exceptions.church;

public class NotFoundChurch extends RuntimeException {
  public NotFoundChurch(String message) {
    super(message);
  }
}
