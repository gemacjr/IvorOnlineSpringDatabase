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
// RETURN STRING
//=======================================================================================
// John,20
    @Query(nativeQuery = true, value = "SELECT name, age FROM PERSON WHERE NAME = 'John' AND AGE = 20")
    String returnString();
    //=======================================================================================
// RETURN SCALAR
//=======================================================================================
// 20
    @Query(nativeQuery = true, value = "SELECT age FROM PERSON WHERE NAME = 'John' AND AGE = 20")
    Integer returnScalar();
}