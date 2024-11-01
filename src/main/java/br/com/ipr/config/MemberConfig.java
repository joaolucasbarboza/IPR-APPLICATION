package br.com.ipr.config;

import br.com.ipr.application.gateways.RepositoryChurch;
import br.com.ipr.application.gateways.RepositoryMember;
import br.com.ipr.application.usecases.MemberUseCase;
import br.com.ipr.infra.gateways.church.ChurchEntityMapper;
import br.com.ipr.infra.gateways.member.MemberEntityMapper;
import br.com.ipr.infra.gateways.member.RepositoryMemberImpl;
import br.com.ipr.infra.persistence.member.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {

  @Bean
  MemberUseCase memberUseCase(
      RepositoryMember repositoryMember,
      RepositoryChurch repositoryChurch,
      MemberEntityMapper memberEntityMapper) {
    return new MemberUseCase(repositoryMember, repositoryChurch, memberEntityMapper);
  }

  @Bean
  RepositoryMemberImpl repositoryMemberJpa(
      MemberRepository memberRepository, MemberEntityMapper memberEntityMapper) {
    return new RepositoryMemberImpl(memberRepository, memberEntityMapper);
  }

  @Bean
  MemberEntityMapper memberEntityMapper(ChurchEntityMapper churchEntityMapper) {
    return new MemberEntityMapper(churchEntityMapper);
  }
}
