package com.volnei.gerenciadordepessoas.mapper;

import com.volnei.gerenciadordepessoas.dto.PersonDTO;
import com.volnei.gerenciadordepessoas.dto.ViewPersonDTO;
import com.volnei.gerenciadordepessoas.dto.ViewPhoneDTO;
import com.volnei.gerenciadordepessoas.entity.Person;
import com.volnei.gerenciadordepessoas.entity.Phone;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PersonMapper {

    public Person toPerson(PersonDTO personDTO) {
        return new Person(
                personDTO.getFirstName(),
                personDTO.getLastName(),
                personDTO.getCpf(),
                personDTO.getBirthDate(),
                personDTO.getPhones().stream().map(x -> new Phone(x.getType(), x.getNumber())).collect(Collectors.toList())
        );
    }

    public ViewPersonDTO toDTO(Person person) {
        return new ViewPersonDTO(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getCpf(),
                person.getBirthDate(),
                person.getPhones().stream().map(x -> new ViewPhoneDTO(x.getId(), x.getType(), x.getNumber())).collect(Collectors.toList())
        );
    }
}