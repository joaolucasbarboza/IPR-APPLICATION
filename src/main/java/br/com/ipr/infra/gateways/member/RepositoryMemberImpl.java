package br.com.ipr.infra.gateways.member;

import br.com.ipr.application.gateways.RepositoryMember;
import br.com.ipr.domain.Member;
import br.com.ipr.infra.exceptions.member.MemberNotFound;
import br.com.ipr.infra.gateways.church.ChurchEntityMapper;
import br.com.ipr.infra.persistence.member.MemberEntity;
import br.com.ipr.infra.persistence.member.MemberRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RepositoryMemberImpl implements RepositoryMember {

  private final MemberRepository memberRepository;
  private final MemberEntityMapper memberEntityMapper;
  private final ChurchEntityMapper churchEntityMapper;

  @Override
  public Member save(Member member) {
    MemberEntity entity = memberEntityMapper.toMemberEntity(member);
    memberRepository.save(entity);

    return memberEntityMapper.toMemberDomain(entity);
  }

  @Override
  public Member association(Member member) {
    MemberEntity entity = memberEntityMapper.toMemberEntity(member);

    entity.setChurch(churchEntityMapper.toChurchEntity(member.getChurch()));
    memberRepository.save(entity);

    return memberEntityMapper.toMemberDomain(entity);
  }

  @Override
  public boolean existsByCpf(String cpf) {
    return memberRepository.findByCpf(cpf).isPresent();
  }

  @Override
  public Member findByCpf(String cpf) {

    MemberEntity entity =
        memberRepository
            .findByCpf(cpf)
            .orElseThrow(() -> new MemberNotFound(String.format("Member CPF %s not found", cpf)));

    return memberEntityMapper.toMemberDomain(entity);
  }

  @Override
  public Optional<MemberEntity> findByEmail(String email) {
    return memberRepository.findByEmail(email);
  }

  @Override
  public List<Member> findAll() {
    List<MemberEntity> entity = memberRepository.findAll();

    return memberEntityMapper.toMemberDomain(entity);
  }
}
