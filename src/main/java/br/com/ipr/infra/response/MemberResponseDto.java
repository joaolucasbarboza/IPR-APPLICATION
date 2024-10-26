package br.com.ipr.infra.response;

import br.com.ipr.domain.member.Member;
import java.time.LocalDate;

public record MemberResponseDto(
    String cpf,
    String name,
    String email,
    String telephone,
    String gender,
    LocalDate birth,
    LocalDate dateRegistered) {

  public MemberResponseDto(Member member) {
    this(
        member.getCpf(),
        member.getName(),
        member.getEmail(),
        member.getTelephone(),
        member.getGender(),
        member.getBirth(),
        member.getDateRegistered());
  }
}
