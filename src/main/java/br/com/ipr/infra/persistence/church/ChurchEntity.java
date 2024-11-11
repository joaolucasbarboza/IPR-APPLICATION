package br.com.ipr.infra.persistence.church;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "church")
@Getter
@Setter
public class ChurchEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank private String name;
  @NotBlank private String surname;
  @NotBlank private String description;
  @NotNull private String image;
  private UUID idShepherd;
}
