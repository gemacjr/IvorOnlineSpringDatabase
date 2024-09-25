package com.swiftbeard.Chapter1.repositories;

import com.swiftbeard.Chapter1.entities.Person;
import com.swiftbeard.Chapter1.entities.PersonProjection;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.*;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    Person returnPerson (String name, Integer age);
    Object returnArray (String name, Integer age);
    Integer returnScalar (String name, Integer age);
    String returnString (String name, Integer age);
}