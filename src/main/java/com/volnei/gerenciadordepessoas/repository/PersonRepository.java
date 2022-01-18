package com.volnei.gerenciadordepessoas.repository;

import com.volnei.gerenciadordepessoas.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}