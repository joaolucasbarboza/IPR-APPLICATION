package br.com.ipr.domain.church;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Church {

    private UUID id;
    private String name;
    private String description;
    private String image;
    private UUID idShepherd;

    public Church( UUID id, String name, String description, String image, UUID idShepherd) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.idShepherd = idShepherd;
    }

    public Church( String name, String description, String image, UUID idShepherd) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.idShepherd = idShepherd;
    }
}
