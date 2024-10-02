package br.com.ipr.domain.entities.church;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Church {

    private UUID id;
    private String name;
    private String description;
    private String image;
    private UUID idShepherd;

}
