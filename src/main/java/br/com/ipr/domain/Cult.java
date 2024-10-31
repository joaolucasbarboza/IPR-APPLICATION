package br.com.ipr.domain;

import java.util.Date;

public class Cult {

  private int id;
  private String title;
  private String description;
  private Date date;

  public Cult(int id, String title, String description, Date date) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.date = date;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
