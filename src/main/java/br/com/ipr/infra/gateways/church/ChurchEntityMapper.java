package br.com.ipr.infra.gateways.church;

import br.com.ipr.domain.church.Church;
import br.com.ipr.infra.persistence.church.ChurchEntity;
import java.util.List;

public class ChurchEntityMapper {

  public ChurchEntity toChurchEntity(Church church) {
    return new ChurchEntity(
        church.getId(),
        church.getName(),
        church.getDescription(),
        church.getImage(),
        church.getIdShepherd());
  }

  public Church toChurchDomain(ChurchEntity churchEntity) {
    return new Church(
        churchEntity.getId(),
        churchEntity.getName(),
        churchEntity.getDescription(),
        churchEntity.getImage(),
        churchEntity.getIdShepherd());
  }

  public List<Church> toChurchDomain(List<ChurchEntity> churches) {
    return churches.stream().map(this::toChurchDomain).toList();
  }
}
