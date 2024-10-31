package br.com.ipr.infra.persistence.department;

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
@Table(name = "department")
@Getter
public class DepartmentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank @Setter private String name;
  @NotBlank @Setter private String description;
  @NotNull @Setter private String image;
  @NotNull private Integer quantMembers;
}
