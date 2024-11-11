package br.com.ipr.infra.exceptions;

import br.com.ipr.infra.exceptions.church.NotFoundChurch;
import br.com.ipr.infra.exceptions.church.ShepherdAlreadyRegistered;
import br.com.ipr.infra.exceptions.member.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(IncorretPatternCPF.class)
  private ResponseEntity<RestErrorMessage> incorretPatternCPF(IncorretPatternCPF exception) {
    RestErrorMessage errorMessage =
        new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
  }

  @ExceptionHandler(MemberNotFound.class)
  private ResponseEntity<RestErrorMessage> memberNotFound(MemberNotFound exception) {
    RestErrorMessage errorMessage =
        new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
  }

  @ExceptionHandler(MemberAlreadyExist.class)
  private ResponseEntity<RestErrorMessage> memberAlreadyExist(MemberAlreadyExist exception) {
    RestErrorMessage errorMessage =
        new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
    return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
  }

  @ExceptionHandler(PasswordTooShortException.class)
  public ResponseEntity<RestErrorMessage> passwordTooShort(PasswordTooShortException exception) {
    RestErrorMessage errorMessage =
        new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
  }

  @ExceptionHandler(InvalidEmailFormat.class)
  public ResponseEntity<RestErrorMessage> invalidEmail(InvalidEmailFormat exception) {
    RestErrorMessage errorMessage =
        new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
  }

  @ExceptionHandler(ShepherdAlreadyRegistered.class)
  public ResponseEntity<RestErrorMessage> shepherdAlreadyRegistered(
      ShepherdAlreadyRegistered exception) {
    RestErrorMessage errorMessage =
        new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
    return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
  }

  @ExceptionHandler(NotFoundChurch.class)
  public ResponseEntity<RestErrorMessage> notFoundChurch(NotFoundChurch exception) {
    RestErrorMessage errorMessage =
        new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
  }

  @ExceptionHandler(EmailAlreadyRegistered.class)
  public ResponseEntity<RestErrorMessage> emailAlreadyRegistered(EmailAlreadyRegistered exception) {
    RestErrorMessage errorMessage =
        new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
    return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
  }

  @ExceptionHandler(ChurchAlreadyAssociatedException.class)
  public ResponseEntity<RestErrorMessage> churchAlreadyAssociatedException(
      ChurchAlreadyAssociatedException exception) {
    RestErrorMessage errorMessage =
        new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
    return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
  }
}
