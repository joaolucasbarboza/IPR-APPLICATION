package br.com.ipr.domain.entities.member;

import java.util.Date;

public class Member {
    private String cpf;
    private String name;
    private String email;
    private String password;
    private String telephone;
    private String gender;
    private Date birth;
    private Date dateRegistered;

    public Member(String cpf, String name, String email, String password, String telephone, String gender, Date birth, Date dateRegistered) {

        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("CPF in incorrect pattern.");
        }

        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.gender = gender;
        this.birth = birth;
        this.dateRegistered = dateRegistered;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }
}
