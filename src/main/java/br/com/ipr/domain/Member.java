package br.com.ipr.domain;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
  private String cpf;
  private String name;
  private String email;
  private String password;
  private String telephone;
  private String gender;
  private LocalDate birth;
  private LocalDate dateRegistered;
  private Church church;

  public Member(
      String cpf,
      String name,
      String email,
      String password,
      String telephone,
      String gender,
      LocalDate birth,
      Church church) {

    this.cpf = cpf;
    this.name = name;
    this.email = email;
    this.password = password;
    this.telephone = telephone;
    this.gender = gender;
    this.birth = birth;
    this.dateRegistered = LocalDate.now();
    this.church = church;
  }
}
