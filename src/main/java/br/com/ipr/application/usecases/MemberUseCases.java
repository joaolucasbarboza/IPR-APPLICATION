package br.com.ipr.application.usecases;

import br.com.ipr.application.gateways.RepositoryMember;
import br.com.ipr.domain.member.Member;
import br.com.ipr.infra.exceptions.member.IncorretPatternCPF;
import br.com.ipr.infra.exceptions.member.InvalidEmailFormat;
import br.com.ipr.infra.exceptions.member.PasswordTooShortException;

import java.util.Optional;

public class MemberUseCases {

  private final RepositoryMember repositoryMember;

  public MemberUseCases(RepositoryMember repositoryMember) {
    this.repositoryMember = repositoryMember;
  }

  public Member registerMember(Member member) {

    Optional.ofNullable(member.getCpf())
            .filter(c -> c.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}"))
            .orElseThrow(IncorretPatternCPF::new);

    Optional.ofNullable(member.getPassword())
            .filter(p -> p.matches("\\d{8}"))
            .orElseThrow(PasswordTooShortException::new);

    Optional.ofNullable(member.getEmail())
            .filter(e -> e.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
            .orElseThrow(InvalidEmailFormat::new);

    return repositoryMember.createMember(member);
  }
}
