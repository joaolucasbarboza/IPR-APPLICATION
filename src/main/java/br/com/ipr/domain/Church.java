package br.com.ipr.domain;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Church {

  private UUID id;
  private String name;
  private String surname;
  private String description;
  private String image;
  private UUID idShepherd;

  public Church(
      UUID id, String name, String surname, String description, String image, UUID idShepherd) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.description = description;
    this.image = image;
    this.idShepherd = idShepherd;
  }

  public Church(String name, String surname, String description, String image, UUID idShepherd) {
    this.name = name;
    this.surname = surname;
    this.description = description;
    this.image = image;
    this.idShepherd = idShepherd;
  }
}
