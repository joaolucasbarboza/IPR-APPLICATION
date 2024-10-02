package br.com.ipr.domain.entities.church;

import java.util.UUID;

public class Church {

    private UUID id;
    private String name;
    private String description;
    private String image;
    private UUID idShepherd;

    public Church(String name, String description, String image, UUID idShepherd) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.idShepherd = idShepherd;
    }

    public Church(UUID id, String name, String description, String image, UUID idShepherd) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.idShepherd = idShepherd;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public UUID getIdShepherd() {
        return idShepherd;
    }

    public void setIdShepherd(UUID idShepherd) {
        this.idShepherd = idShepherd;
    }
}
