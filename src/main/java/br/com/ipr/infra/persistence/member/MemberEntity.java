package br.com.ipr.infra.persistence.member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Table(name = "member")
@Getter
@Setter
public class MemberEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotNull private String cpf;

  @NotNull private String name;

  @NotNull private String email;

  private String password;
  private String telephone;
  private String gender;
  private LocalDate birth;
  private LocalDate dateRegistered;

  public MemberEntity() {}

  public MemberEntity(
      String cpf,
      String name,
      String email,
      String password,
      String telephone,
      String gender,
      LocalDate birth) {
    this.cpf = cpf;
    this.name = name;
    this.email = email;
    this.password = password;
    this.telephone = telephone;
    this.gender = gender;
    this.birth = birth;
    this.dateRegistered = LocalDate.now();
  }
}
