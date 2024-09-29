package br.com.ipr.application.usecases;

import br.com.ipr.application.gateways.RepositoryMember;
import br.com.ipr.domain.entities.member.Member;

public class CreateMember {

    private final RepositoryMember repositoryMember;

    public CreateMember(RepositoryMember repositoryMember) {
        this.repositoryMember = repositoryMember;
    }

    public Member registerMember(Member member) {
        return repositoryMember.createMember(member);
    }
}
