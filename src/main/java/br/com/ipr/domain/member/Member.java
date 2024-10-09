package br.com.ipr.domain.member;

import br.com.ipr.infra.exceptions.member.IncorretPatternCPF;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

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

    public Member(String cpf, String name, String email, String password, String telephone, String gender, LocalDate birth) {

        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IncorretPatternCPF();
        }

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
