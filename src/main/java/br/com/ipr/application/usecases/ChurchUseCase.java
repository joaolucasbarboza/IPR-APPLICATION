package br.com.ipr.application.usecases;

import br.com.ipr.application.gateways.RepositoryChurch;
import br.com.ipr.domain.Church;
import br.com.ipr.infra.exceptions.church.ShepherdAlreadyRegistered;
import br.com.ipr.infra.gateways.church.ChurchEntityMapper;
import br.com.ipr.infra.request.ChurchRequestDto;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChurchUseCase {

  private final RepositoryChurch repositoryChurch;
  private final ChurchEntityMapper churchEntityMapper;

  public Church create(ChurchRequestDto requestDto) {

    if (repositoryChurch.existsByShepherd(requestDto.idShepherd())) {
      throw new ShepherdAlreadyRegistered();
    }

    Church church = churchEntityMapper.toChurchDomain(requestDto);
    return repositoryChurch.createChurch(church);
  }

  public List<Church> findAll() {
    return repositoryChurch.findAll();
  }
}
