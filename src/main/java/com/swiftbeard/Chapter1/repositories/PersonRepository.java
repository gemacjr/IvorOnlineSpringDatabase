package com.swiftbeard.Chapter1.repositories;

import com.swiftbeard.Chapter1.entities.Person;
import com.swiftbeard.Chapter1.entities.PersonDTO;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    //=======================================================================================
// RETURN PERSON DTO
//=======================================================================================
//Needs fully qualified DTO name. Imports are not used.
    @Query(value = "" +
            "FROM Person person " +
            "WHERE person.name = 'John'"
    )
    PersonDTO returnPersonDTO();
}