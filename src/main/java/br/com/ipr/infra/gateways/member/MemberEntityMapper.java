package br.com.ipr.infra.gateways.member;

import br.com.ipr.domain.Church;
import br.com.ipr.domain.Member;
import br.com.ipr.infra.gateways.church.ChurchEntityMapper;
import br.com.ipr.infra.persistence.member.MemberEntity;
import br.com.ipr.infra.request.MemberRequestDto;
import java.util.List;

public class MemberEntityMapper {

  private final ChurchEntityMapper churchEntityMapper;

  public MemberEntityMapper(ChurchEntityMapper churchEntityMapper) {
    this.churchEntityMapper = churchEntityMapper;
  }

  public Member toMemberDomain(MemberRequestDto memberRequestDto, Church church) {
    return new Member(
        memberRequestDto.cpf(),
        memberRequestDto.name(),
        memberRequestDto.email(),
        memberRequestDto.password(),
        memberRequestDto.telephone(),
        memberRequestDto.gender(),
        memberRequestDto.birth(),
        church);
  }

  public MemberEntity toMemberEntity(Member member) {
    return new MemberEntity(
        member.getCpf(),
        member.getName(),
        member.getEmail(),
        member.getPassword(),
        member.getTelephone(),
        member.getGender(),
        member.getBirth(),
        churchEntityMapper.toChurchEntity(member.getChurch()));
  }

  public Member toMemberDomain(MemberEntity memberEntity) {
    return new Member(
        memberEntity.getCpf(),
        memberEntity.getName(),
        memberEntity.getEmail(),
        memberEntity.getPassword(),
        memberEntity.getTelephone(),
        memberEntity.getGender(),
        memberEntity.getBirth(),
        churchEntityMapper.toChurchDomain(memberEntity.getChurch()));
  }

  public List<Member> toMemberDomain(List<MemberEntity> memberEntityList) {
    return memberEntityList.stream().map(this::toMemberDomain).toList();
  }
}
