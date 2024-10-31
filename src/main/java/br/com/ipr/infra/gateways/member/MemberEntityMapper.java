package br.com.ipr.infra.gateways.member;

import br.com.ipr.domain.Member;
import br.com.ipr.infra.persistence.member.MemberEntity;
import java.util.List;

public class MemberEntityMapper {

  public MemberEntity toMemberEntity(Member member) {
    return new MemberEntity(
        member.getCpf(),
        member.getName(),
        member.getEmail(),
        member.getPassword(),
        member.getTelephone(),
        member.getGender(),
        member.getBirth());
  }

  public Member toMemberDomain(MemberEntity memberEntity) {
    return new Member(
        memberEntity.getCpf(),
        memberEntity.getName(),
        memberEntity.getEmail(),
        memberEntity.getPassword(),
        memberEntity.getTelephone(),
        memberEntity.getGender(),
        memberEntity.getBirth());
  }

  public List<Member> toMemberDomain(List<MemberEntity> memberEntityList) {
    return memberEntityList.stream().map(this::toMemberDomain).toList();
  }
}
