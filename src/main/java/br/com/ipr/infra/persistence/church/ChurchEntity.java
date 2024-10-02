package br.com.ipr.infra.persistence.church;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "church")
@Getter
@Setter
public class ChurchEntity {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank private String name;
    @NotBlank private String description;
    @NotNull private String image;
    @NotNull private UUID idShepherd;
}
