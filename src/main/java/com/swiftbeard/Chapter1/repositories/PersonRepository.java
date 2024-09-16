package com.swiftbeard.Chapter1.repositories;

import com.swiftbeard.Chapter1.entities.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    //=======================================================================================
// SELECT PERSON BY NAME AGE
//=======================================================================================
    @Query(value = "SELECT * FROM PERSON WHERE NAME = :name AND AGE = :age", nativeQuery = true)
    Person selectPersonByNameAge(String name, Integer age);
}