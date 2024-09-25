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
// SELECT PERSON
//================================================================
    @RequestMapping("SelectPerson")
    PersonDTO selectPerson() {
//CREATE QUERY
        String select = "SELECT name, age FROM Person WHERE name = :name";
        Query query = entityManager.createNativeQuery(select, "PersonViewMapping");
        query.setParameter("name", "John");
//SELECT PERSON
        PersonDTO personDTO = (PersonDTO) query.getSingleResult();
//RETURN PERSON
        return personDTO;
    }