package br.com.ipr.infra.exceptions.member;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class IncorretPatternCPF extends RuntimeException {
    public IncorretPatternCPF() {
        super("Incorrect CPF pattern.");
    }

    public IncorretPatternCPF(String message) {
        super(message);
    }
}
