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
    @PersistenceContext
    EntityManager entityManager;

    @RequestMapping("SelectPerson")
    Object[] selectPerson() {
//CREATE QUERY
        String select = "SELECT id, name, age, name || ' is ' || age AS greet FROM Person WHERE name = :name";
        Query query = entityManager.createNativeQuery(select, "PersonMapping");
        query.setParameter("name", "John");
//SELECT PERSON
        Object[] objectArray = (Object[]) query.getSingleResult();
//RETURN PERSON
        return objectArray;
    }
}