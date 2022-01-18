package com.volnei.gerenciadordepessoas.controller;

import com.volnei.gerenciadordepessoas.dto.PersonDTO;
import com.volnei.gerenciadordepessoas.dto.ViewPersonDTO;
import com.volnei.gerenciadordepessoas.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ViewPersonDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<ViewPersonDTO> listAll() {
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public ViewPersonDTO findById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PutMapping("/{id}")
    public ViewPersonDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) {
        return personService.updateById(id, personDTO);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) { // TODO Tratar erro
        personService.delete(id);
    }
}