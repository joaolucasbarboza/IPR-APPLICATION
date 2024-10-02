package br.com.ipr.infra.exceptions.member;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MemberNotFound extends RuntimeException {
    public MemberNotFound(final String message) {
        super(message);
    }

    public MemberNotFound() {
        super("Member not found.");
    }

}
