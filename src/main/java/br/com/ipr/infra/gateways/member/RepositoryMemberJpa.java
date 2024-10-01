package br.com.ipr.infra.gateways.member;

import br.com.ipr.application.gateways.RepositoryMember;
import br.com.ipr.domain.entities.member.Member;
import br.com.ipr.infra.persistence.member.MemberEntity;
import br.com.ipr.infra.persistence.member.MemberRepository;

public class RepositoryMemberJpa implements RepositoryMember {

    private final MemberRepository memberRepository;
    private final MemberEntityMapper memberEntityMapper;

    public RepositoryMemberJpa(MemberRepository memberRepository, MemberEntityMapper memberEntityMapper) {
        this.memberRepository = memberRepository;
        this.memberEntityMapper = memberEntityMapper;
    }

    @Override
    public Member createMember(Member member) {
        MemberEntity entity = memberEntityMapper.toEntity(member);
        memberRepository.save(entity);
        return memberEntityMapper.toDomain(entity);
    }
}
