package br.com.ipr.infra.gateways.member;

import br.com.ipr.domain.member.Member;
import br.com.ipr.infra.persistence.member.MemberEntity;

public class MemberEntityMapper {

  public MemberEntity toEntity(Member member) {
    return new MemberEntity(
        member.getCpf(),
        member.getName(),
        member.getEmail(),
        member.getPassword(),
        member.getTelephone(),
        member.getGender(),
        member.getBirth());
  }

  public Member toDomain(MemberEntity memberEntity) {
    return new Member(
        memberEntity.getCpf(),
        memberEntity.getName(),
        memberEntity.getEmail(),
        memberEntity.getPassword(),
        memberEntity.getTelephone(),
        memberEntity.getGender(),
        memberEntity.getBirth());
  }
}
