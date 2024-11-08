package br.com.ipr.infra.gateways.church;

import br.com.ipr.domain.Church;
import br.com.ipr.infra.persistence.church.ChurchEntity;
import br.com.ipr.infra.request.ChurchRequestDto;
import java.util.List;

public class ChurchEntityMapper {

  public ChurchEntity toChurchEntity(Church church) {
    return new ChurchEntity(
        church.getId(),
        church.getName(),
        church.getSurname(),
        church.getDescription(),
        church.getImage(),
        church.getIdShepherd());
  }

  public Church toChurchDomain(ChurchEntity churchEntity) {
    return new Church(
        churchEntity.getId(),
        churchEntity.getName(),
        churchEntity.getSurname(),
        churchEntity.getDescription(),
        churchEntity.getImage(),
        churchEntity.getIdShepherd());
  }

  public Church toChurchDomain(ChurchRequestDto churchRequestDto) {
    return new Church(
        churchRequestDto.name(),
        churchRequestDto.surname(),
        churchRequestDto.description(),
        churchRequestDto.image(),
        churchRequestDto.idShepherd());
  }

  public List<Church> toChurchDomain(List<ChurchEntity> churches) {
    return churches.stream().map(this::toChurchDomain).toList();
  }
}
