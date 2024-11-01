package br.com.ipr.config;

import br.com.ipr.application.gateways.RepositoryChurch;
import br.com.ipr.application.usecases.ChurchUseCase;
import br.com.ipr.infra.gateways.church.ChurchEntityMapper;
import br.com.ipr.infra.gateways.church.RepositoryChurchImpl;
import br.com.ipr.infra.persistence.church.ChurchRepository;
import br.com.ipr.infra.persistence.member.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChurchConfig {

  @Bean
  ChurchUseCase churchUseCase(
      RepositoryChurch repositoryChurch, ChurchEntityMapper churchEntityMapper) {
    return new ChurchUseCase(repositoryChurch, churchEntityMapper);
  }

  @Bean
  RepositoryChurchImpl repositoryChurchJpa(
      ChurchRepository churchRepository,
      ChurchEntityMapper churchEntityMapper,
      MemberRepository memberRepository) {
    return new RepositoryChurchImpl(churchRepository, churchEntityMapper, memberRepository);
  }

  @Bean
  ChurchEntityMapper churchEntityMapper() {
    return new ChurchEntityMapper();
  }
}
