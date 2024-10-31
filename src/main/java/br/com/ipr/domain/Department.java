package br.com.ipr.domain;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Department {

  private UUID id;
  @Setter private String name;
  @Setter private String description;
  @Setter private String image;
  @Setter private Integer quantMembers = 0;

  public Department(String name, String description, String image) {
    this.name = name;
    this.description = description;
    this.image = image;
  }

    public Department(String name, String description, String image, Integer quantMembers) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.quantMembers = quantMembers;
    }
}
