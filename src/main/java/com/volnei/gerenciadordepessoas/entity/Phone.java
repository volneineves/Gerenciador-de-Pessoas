package com.volnei.gerenciadordepessoas.entity;

import com.volnei.gerenciadordepessoas.enums.PhoneType;

import javax.persistence.*;

@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String number;

    public Phone() {
    }

    public Phone(PhoneType type, String number) {
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