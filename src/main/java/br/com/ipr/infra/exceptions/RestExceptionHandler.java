package br.com.ipr.infra.exceptions;

import br.com.ipr.infra.exceptions.member.IncorretPatternCPF;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IncorretPatternCPF.class)
    private ResponseEntity<RestErrorMessage> incorretPatternCPF(IncorretPatternCPF exception) {
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}
