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
// RETURN JSON RECORD
//=======================================================================================
// {"name":"John","age":21}
    @Query(
            value =
                    "SELECT CAST(row_to_json(EXPRESSION) AS VARCHAR)" +
                            "FROM (SELECT name, age FROM PERSON WHERE NAME = 'John' AND AGE = 20) AS EXPRESSION"
            ,
            nativeQuery = true
    )
    String returnJSONRecord();
    //=======================================================================================
// RETURN JSON ARRAY
//=======================================================================================
// [{"name":"John","age":20},{"name":"John","age":21}] Returns String that looks like JSON Array
// [] Returns [] if no Records are found
    @Query(
            value =
                    "SELECT CAST(COALESCE(json_agg(EXPRESSION), '[]') AS varchar) " +
                            "FROM (SELECT name, age FROM PERSON WHERE NAME = 'John') AS EXPRESSION"
            ,
            nativeQuery = true
    )
    String returnJSONArray();
}