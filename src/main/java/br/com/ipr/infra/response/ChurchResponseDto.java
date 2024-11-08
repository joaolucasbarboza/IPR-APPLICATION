package br.com.ipr.infra.response;

import br.com.ipr.domain.Church;
import java.util.UUID;

public record ChurchResponseDto(
    UUID id, String name, String surname, String description, String image, UUID idShepherd) {

  public ChurchResponseDto(Church church) {
    this(
        church.getId(),
        church.getName(),
        church.getSurname(),
        church.getDescription(),
        church.getImage(),
        church.getIdShepherd());
  }
}
