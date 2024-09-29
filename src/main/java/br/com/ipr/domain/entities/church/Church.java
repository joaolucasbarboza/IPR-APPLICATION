package br.com.ipr.domain.entities.church;

public class Church {

    private int id;
    private String name;
    private String description;
    private String image;
    private String idShepherd;

    public Church(int id, String name, String description, String image, String idShepherd) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.idShepherd = idShepherd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getIdShepherd() {
        return idShepherd;
    }

    public void setIdShepherd(String idShepherd) {
        this.idShepherd = idShepherd;
    }
}
