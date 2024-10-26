package br.com.ipr.config;

import br.com.ipr.application.gateways.RepositoryChurch;
import br.com.ipr.application.usecases.church.CreateChurch;
import br.com.ipr.application.usecases.church.GetAllChurches;
import br.com.ipr.infra.gateways.church.ChurchEntityMapper;
import br.com.ipr.infra.gateways.church.RepositoryChurchImpl;
import br.com.ipr.infra.persistence.church.ChurchRepository;
import br.com.ipr.infra.persistence.member.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChurchConfig {

  @Bean
  CreateChurch createChurch(RepositoryChurch repositoryChurch) {
    return new CreateChurch(repositoryChurch);
  }

  @Bean
  GetAllChurches getAllChurches(RepositoryChurch repositoryChurch) {
    return new GetAllChurches(repositoryChurch);
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
