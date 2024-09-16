package com.swiftbeard.Chapter1.repositories;

import com.swiftbeard.Chapter1.entities.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    Person selectPerson(String name, Integer age );
    @Transactional @Modifying Integer updatePerson(String name, Integer newAge);
    @Transactional @Modifying Integer deletePerson(String name );
}