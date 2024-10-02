package br.com.ipr.application.gateways;

import br.com.ipr.domain.entities.church.Church;

public interface RepositoryChurch {

    Church createChurch(Church church);
}
