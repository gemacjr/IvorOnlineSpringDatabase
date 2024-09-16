package com.swiftbeard.Chapter1.repositories;

import com.swiftbeard.Chapter1.entities.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    Person returnEntity (String name);
    Object returnObjectArray(String name);
    String returnString (String name);
    Integer returnScalar (String name);
}