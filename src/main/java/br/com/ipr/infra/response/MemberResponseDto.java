package br.com.ipr.infra.response;

import br.com.ipr.domain.Church;
import br.com.ipr.domain.Member;
import java.time.LocalDate;

public record MemberResponseDto(
    String cpf,
    String name,
    String email,
    String telephone,
    String gender,
    LocalDate birth,
    LocalDate dateRegistered,
    Church church) {

  public MemberResponseDto(Member member) {
    this(
        member.getCpf(),
        member.getName(),
        member.getEmail(),
        member.getTelephone(),
        member.getGender(),
        member.getBirth(),
        member.getDateRegistered(),
        member.getChurch());
  }
}
