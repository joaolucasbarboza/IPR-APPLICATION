package br.com.ipr.application.usecases.church;

import br.com.ipr.application.gateways.RepositoryChurch;
import br.com.ipr.domain.Church;
import br.com.ipr.infra.exceptions.church.ShepherdAlreadyRegistered;

public class CreateChurch {

  private final RepositoryChurch repositoryChurch;

  public CreateChurch(RepositoryChurch repositoryChurch) {
    this.repositoryChurch = repositoryChurch;
  }

  public Church registerChurch(Church church) {

    if (repositoryChurch.existsByShepherd(church.getIdShepherd())) {
      throw new ShepherdAlreadyRegistered();
    }

    return repositoryChurch.createChurch(church);
  }
}
