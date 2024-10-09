package br.com.ipr.infra.gateways.church;

import br.com.ipr.domain.church.Church;
import br.com.ipr.infra.persistence.church.ChurchEntity;

public class ChurchEntityMapper {

    public ChurchEntity toEntity(Church church) {
        return new ChurchEntity(
                church.getId(),
                church.getName(),
                church.getDescription(),
                church.getImage(),
                church.getIdShepherd()
        );
    }

    public Church toDomain(ChurchEntity churchEntity) {
        return new Church(
                churchEntity.getId(),
                churchEntity.getName(),
                churchEntity.getDescription(),
                churchEntity.getImage(),
                churchEntity.getIdShepherd()
        );
    }
}
