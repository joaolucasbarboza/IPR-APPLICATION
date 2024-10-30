package br.com.ipr.application.usecases;

import br.com.ipr.application.gateways.RepositoryMember;
import br.com.ipr.domain.member.Member;
import br.com.ipr.infra.exceptions.member.*;
import java.util.Optional;

public class MemberUseCase {

  private final RepositoryMember repositoryMember;

  public MemberUseCase(RepositoryMember repositoryMember) {
    this.repositoryMember = repositoryMember;
  }

  public Member registerMember(Member member) {
    validateCpf(member.getCpf());
    validateEmail(member.getEmail());
    validatePassword(member.getPassword());

    return repositoryMember.createMember(member);
  }

  private void validatePassword(String password) {
    Optional.ofNullable(password)
        .filter(p -> p.matches("\\d{8}"))
        .orElseThrow(PasswordTooShortException::new);
  }

  private void validateEmail(String email) {
    Optional.ofNullable(email)
        .filter(e -> e.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
        .orElseThrow(InvalidEmailFormat::new);

    if (repositoryMember.findByEmail(email).isPresent()) {
      throw new EmailAlreadyRegistered(String.format("Email %s already registered", email));
    }
  }

  private void validateCpf(String cpf) {
    Optional.ofNullable(cpf)
        .filter(c -> c.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}"))
        .orElseThrow(IncorretPatternCPF::new);

    if (repositoryMember.findByCpf(cpf).isPresent()) {
      throw new MemberAlreadyExist(String.format("CPF %s already registered", cpf));
    }
  }
}
