package com.swiftbeard.Chapter1.repositories;

import com.swiftbeard.Chapter1.entities.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    Object selectPerson(String name);
}