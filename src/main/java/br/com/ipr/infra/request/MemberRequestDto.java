package br.com.ipr.infra.request;

import java.time.LocalDate;
import java.util.UUID;

public record MemberRequestDto(
    String cpf,
    String name,
    String email,
    String password,
    String telephone,
    String gender,
    LocalDate birth,
    UUID churchId) {}
