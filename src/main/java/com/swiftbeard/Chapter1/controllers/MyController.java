package com.swiftbeard.Chapter1.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.swiftbeard.Chapter1.entities.*;
import com.swiftbeard.Chapter1.repositories.*;
import com.swiftbeard.Chapter1.service.DBAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import javax.transaction.*;
import java.util.List;

@RestController
public class MyController {//PROPERTIES

    //PROPERTIES
    @PersistenceContext EntityManager entityManager;
    //================================================================
// RETURN PERSON
//================================================================
    @RequestMapping("ReturnPerson")
    Person returnPerson() {
//CREATE QUERY
        String select = "SELECT * FROM Person WHERE name = :name";
        Query query = entityManager.createNativeQuery(select, Person.class);
        query.setParameter("name", "John");
        //RETURN PERSON
        Person person = (Person) query.getSingleResult();
//RETURN PERSON
        return person;
    }
    //================================================================
// RETURN ARRAY
//================================================================
    @RequestMapping("ReturnArray")
    Object[] returnArray() {
//CREATE QUERY
        String select = "SELECT age, name FROM Person WHERE name = :name";
        Query query = entityManager.createNativeQuery(select);
        query.setParameter("name"
                , "John");
//RETURN ARRAY
        Object[] array = (Object[]) query.getSingleResult();
//RETURN ARRAY
        return array;
    }
    //================================================================
// RETURN SCALAR
//================================================================
    @RequestMapping("ReturnScalar")
    Integer returnScalar() {
//CREATE QUERY
        String select = "SELECT age FROM Person WHERE name = :name";
        Query query = entityManager.createNativeQuery(select);
        query.setParameter("name", "John");
//RETURN SCALAR
        Integer age = (Integer) query.getSingleResult();
//RETURN SCALAR
        return age;
    }
    //================================================================
// RETURN STRING (NOT WORKING)
//================================================================
    @RequestMapping("ReturnString")
    String returnString() {
//CREATE QUERY
        String select = "SELECT name, age FROM Person WHERE name = :name";
        Query query = entityManager.createNativeQuery(select);
        query.setParameter("name", "John");
//SELECT STRING
        String nameAge = (String) query.getSingleResult(); //Throws Error
//RETURN STRING
        return nameAge;
    }
}