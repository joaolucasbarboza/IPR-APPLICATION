package br.com.ipr.config;

import br.com.ipr.application.gateways.RepositoryMember;
import br.com.ipr.application.usecases.member.CreateMember;
import br.com.ipr.infra.gateways.member.MemberEntityMapper;
import br.com.ipr.infra.gateways.member.RepositoryMemberJpa;
import br.com.ipr.infra.persistence.member.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {

    @Bean
    CreateMember createMember(RepositoryMember repositoryMember) {
        return new CreateMember(repositoryMember);
    }

    @Bean
    RepositoryMemberJpa repositoryMemberJpa(MemberRepository memberRepository, MemberEntityMapper memberEntityMapper) {
        return new RepositoryMemberJpa(memberRepository, memberEntityMapper);
    }

    @Bean
    MemberEntityMapper memberEntityMapper() {
        return new MemberEntityMapper();
    }

}
