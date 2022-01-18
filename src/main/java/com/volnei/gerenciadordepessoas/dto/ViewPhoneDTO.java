package com.volnei.gerenciadordepessoas.dto;

import com.volnei.gerenciadordepessoas.enums.PhoneType;

public class ViewPhoneDTO {

    private Long id;
    private PhoneType type;
    private String number;

    public ViewPhoneDTO() {
    }

    public ViewPhoneDTO(Long id, PhoneType type, String number) {
        this.id = id;
        this.type = type;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public PhoneType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}