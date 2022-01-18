package com.volnei.gerenciadordepessoas.dto;

import com.volnei.gerenciadordepessoas.enums.PhoneType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PhoneDTO {

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @NotEmpty
    @Size(min = 13, max = 16)
    private String number;

    public PhoneDTO() {
    }

    public PhoneType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}