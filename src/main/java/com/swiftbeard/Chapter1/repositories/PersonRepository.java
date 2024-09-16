package com.swiftbeard.Chapter1.repositories;

import com.swiftbeard.Chapter1.entities.Person;
import com.swiftbeard.Chapter1.entities.PersonProjection;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    //=======================================================================================
// RETURN OBJECT ARRAY
//=======================================================================================
// ["John",20]
    @Query(nativeQuery = true, value = "SELECT name, age FROM PERSON WHERE NAME = 'John'")
    Object returnObjectArray();
}