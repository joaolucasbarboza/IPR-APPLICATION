package br.com.ipr.config;

import br.com.ipr.application.gateways.RepositoryChurch;
import br.com.ipr.application.gateways.RepositoryMember;
import br.com.ipr.application.usecases.member.MemberUseCase;
import br.com.ipr.application.usecases.member.MemberChurchAssociationUseCase;
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
  MemberChurchAssociationUseCase memberChurchAssociationUseCase(
      RepositoryMember repositoryMember, RepositoryChurch repositoryChurch) {
    return new MemberChurchAssociationUseCase(repositoryMember, repositoryChurch);
  }

  @Bean
  RepositoryMemberImpl repositoryMemberJpa(
      MemberRepository memberRepository,
      MemberEntityMapper memberEntityMapper,
      ChurchEntityMapper churchEntityMapper) {
    return new RepositoryMemberImpl(memberRepository, memberEntityMapper, churchEntityMapper);
  }

  @Bean
  MemberEntityMapper memberEntityMapper(ChurchEntityMapper churchEntityMapper) {
    return new MemberEntityMapper(churchEntityMapper);
  }
}
