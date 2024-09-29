package br.com.ipr.domain.entities.event;

public class Event {

    private String id;
    private String name;
    private String description;
    private String location;
    private String department;
    private String price;
    private String vacanciesTotal;
    private String vacanciesAvailable;
    private String vacanciesReserved;

    public Event(String id, String name, String description, String location, String department, String price, String vacanciesTotal, String vacanciesAvailable, String vacanciesReserved) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.department = department;
        this.price = price;
        this.vacanciesTotal = vacanciesTotal;
        this.vacanciesAvailable = vacanciesAvailable;
        this.vacanciesReserved = vacanciesReserved;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVacanciesTotal() {
        return vacanciesTotal;
    }

    public void setVacanciesTotal(String vacanciesTotal) {
        this.vacanciesTotal = vacanciesTotal;
    }

    public String getVacanciesAvailable() {
        return vacanciesAvailable;
    }

    public void setVacanciesAvailable(String vacanciesAvailable) {
        this.vacanciesAvailable = vacanciesAvailable;
    }

    public String getVacanciesReserved() {
        return vacanciesReserved;
    }

    public void setVacanciesReserved(String vacanciesReserved) {
        this.vacanciesReserved = vacanciesReserved;
    }
}
