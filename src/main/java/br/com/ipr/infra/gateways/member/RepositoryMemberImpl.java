package br.com.ipr.infra.gateways.member;

import br.com.ipr.application.gateways.RepositoryMember;
import br.com.ipr.domain.member.Member;
import br.com.ipr.infra.exceptions.member.MemberAlreadyExist;
import br.com.ipr.infra.persistence.member.MemberEntity;
import br.com.ipr.infra.persistence.member.MemberRepository;

import java.util.Optional;

public class RepositoryMemberImpl implements RepositoryMember {

    private final MemberRepository memberRepository;
    private final MemberEntityMapper memberEntityMapper;

    public RepositoryMemberImpl(MemberRepository memberRepository, MemberEntityMapper memberEntityMapper) {
        this.memberRepository = memberRepository;
        this.memberEntityMapper = memberEntityMapper;
    }

    @Override
    public Member createMember(Member member) {
        MemberEntity entity = memberEntityMapper.toEntity(member);

        Optional<MemberEntity> existsMember = memberRepository.findByCpf(member.getCpf());

        if (existsMember.isPresent()) {
            throw new MemberAlreadyExist();
        }

        memberRepository.save(entity);
        return memberEntityMapper.toDomain(entity);
    }
}
