package br.com.ipr.application.usecases.church;

import br.com.ipr.application.gateways.RepositoryChurch;
import br.com.ipr.domain.church.Church;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAllChurches {

  private final RepositoryChurch repository;

  public List<Church> getAll() {
    return repository.getAllChurches();
  }
}
