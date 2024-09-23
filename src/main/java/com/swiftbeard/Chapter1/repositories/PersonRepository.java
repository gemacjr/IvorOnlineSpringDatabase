package com.swiftbeard.Chapter1.repositories;

import com.swiftbeard.Chapter1.entities.Person;
import com.swiftbeard.Chapter1.entities.PersonProjection;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.*;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    Person selectPerson(String name, Integer age );
    @Transactional
    @Modifying Integer insertPerson(String name, Integer age );
    @Transactional @Modifying Integer updatePerson(String name, Integer newAge);
    @Transactional @Modifying Integer deletePerson(String name );
}