package br.com.ipr.domain.member;

import br.com.ipr.infra.exceptions.member.IncorretPatternCPF;
import br.com.ipr.infra.exceptions.member.InvalidEmailFormat;
import br.com.ipr.infra.exceptions.member.PasswordTooShortException;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;

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

        Optional.ofNullable(cpf)
                .filter(c -> c.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}"))
                .orElseThrow(IncorretPatternCPF::new);

        Optional.ofNullable(password)
                .filter(p -> p.matches("\\d{8}"))
                .orElseThrow(PasswordTooShortException::new);

        Optional.ofNullable(email)
                .filter(e -> e.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
                .orElseThrow(InvalidEmailFormat::new);

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
