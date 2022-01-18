package com.volnei.gerenciadordepessoas.dto;

import java.time.LocalDate;
import java.util.List;

public class ViewPersonDTO {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String cpf;
    private final LocalDate birthDate;
    private final List<ViewPhoneDTO> phones;

    public ViewPersonDTO(Long id, String firstName, String lastName, String cpf, LocalDate birthDate, List<ViewPhoneDTO> phones) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.phones = phones;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<ViewPhoneDTO> getPhones() {
        return phones;
    }
}