package br.com.ipr.infra.response;

import java.time.LocalDate;
import java.util.Date;

public record MemberResponseDto(
        String cpf,
        String name,
        String email,
        String telephone,
        String gender,
        LocalDate birth,
        LocalDate dateRegistered
) {
}
