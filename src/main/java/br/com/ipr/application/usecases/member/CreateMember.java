package br.com.ipr.application.usecases.member;

import br.com.ipr.application.gateways.RepositoryMember;
import br.com.ipr.domain.member.Member;

public class CreateMember {

    private final RepositoryMember repositoryMember;

    public CreateMember(RepositoryMember repositoryMember) {
        this.repositoryMember = repositoryMember;
    }

    public Member registerMember(Member member) {
        return repositoryMember.createMember(member);
    }
}
