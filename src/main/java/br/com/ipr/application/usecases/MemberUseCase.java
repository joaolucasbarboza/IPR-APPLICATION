package br.com.ipr.application.usecases;

import br.com.ipr.application.gateways.RepositoryChurch;
import br.com.ipr.application.gateways.RepositoryMember;
import br.com.ipr.domain.Church;
import br.com.ipr.domain.Member;
import br.com.ipr.infra.exceptions.member.*;
import br.com.ipr.infra.gateways.member.MemberEntityMapper;
import br.com.ipr.infra.request.MemberRequestDto;
import java.util.Optional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberUseCase {

  private final RepositoryMember repositoryMember;
  private final RepositoryChurch repositoryChurch;
  private final MemberEntityMapper memberEntityMapper;

  public Member create(MemberRequestDto memberRequestDto) {
    validateCpf(memberRequestDto.cpf());
    validateEmail(memberRequestDto.email());
    validatePassword(memberRequestDto.password());

    Church church = null;
    if (memberRequestDto.churchId() != null) {
      church = repositoryChurch.findById(memberRequestDto.churchId());
    }

    Member member = memberEntityMapper.toMemberDomain(memberRequestDto, church);

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

    if (repositoryMember.findByCpf(cpf)) {
      throw new MemberAlreadyExist(String.format("CPF %s already registered", cpf));
    }
  }
}
