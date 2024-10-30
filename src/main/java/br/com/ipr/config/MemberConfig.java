package br.com.ipr.config;

import br.com.ipr.application.gateways.RepositoryMember;
import br.com.ipr.application.usecases.MemberUseCases;
import br.com.ipr.infra.gateways.member.MemberEntityMapper;
import br.com.ipr.infra.gateways.member.RepositoryMemberImpl;
import br.com.ipr.infra.persistence.member.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {

  @Bean
  MemberUseCases createMember(RepositoryMember repositoryMember) {
    return new MemberUseCases(repositoryMember);
  }

  @Bean
  RepositoryMemberImpl repositoryMemberJpa(
      MemberRepository memberRepository, MemberEntityMapper memberEntityMapper) {
    return new RepositoryMemberImpl(memberRepository, memberEntityMapper);
  }

  @Bean
  MemberEntityMapper memberEntityMapper() {
    return new MemberEntityMapper();
  }
}
