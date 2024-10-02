package br.com.ipr.application.usecases.church;

import br.com.ipr.application.gateways.RepositoryChurch;
import br.com.ipr.domain.entities.church.Church;

public class CreateChurch {

    private final RepositoryChurch repositoryChurch;


    public CreateChurch(RepositoryChurch repositoryChurch) {
        this.repositoryChurch = repositoryChurch;
    }

    public Church registerChurch(Church church) {
        return repositoryChurch.createChurch(church);
    }
}
