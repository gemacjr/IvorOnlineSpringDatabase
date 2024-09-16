package com.swiftbeard.Chapter1.repositories;

import com.swiftbeard.Chapter1.entities.Person;
import com.swiftbeard.Chapter1.entities.PersonProjection;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    PersonProjection findPersonProjectionByName(String name); //Project Entity to Interface
}
