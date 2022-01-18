package com.volnei.gerenciadordepessoas.service;

import com.volnei.gerenciadordepessoas.dto.PersonDTO;
import com.volnei.gerenciadordepessoas.dto.ViewPersonDTO;
import com.volnei.gerenciadordepessoas.entity.Person;
import com.volnei.gerenciadordepessoas.entity.Phone;
import com.volnei.gerenciadordepessoas.exception.NotFound;
import com.volnei.gerenciadordepessoas.mapper.PersonMapper;
import com.volnei.gerenciadordepessoas.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public ViewPersonDTO createPerson(PersonDTO personDTO) {
        Person person = personRepository.save(personMapper.toPerson(personDTO));
        return personMapper.toDTO(person);
    }

    public List<ViewPersonDTO> listAll() {
        return personRepository.findAll().stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ViewPersonDTO findById(Long id) {
        Person person = verifyIfExists(id);
                return personMapper.toDTO(person);
    }

    public void delete(Long id) {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public ViewPersonDTO updateById(Long id, PersonDTO personDTO) {
        Person person = verifyIfExists(id);
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setCpf(personDTO.getCpf());
        person.setBirthDate(personDTO.getBirthDate());
        person.setPhones(personDTO.getPhones().stream().map(x -> new Phone(x.getType(), x.getNumber())).collect(Collectors.toList()));
        return personMapper.toDTO(personRepository.save(person));
    }

    private Person verifyIfExists(Long id){
        return personRepository
                .findById(id)
                .orElseThrow(() -> new NotFound("Client not found with id: ", id));  // TODO tratar erro
    }
}