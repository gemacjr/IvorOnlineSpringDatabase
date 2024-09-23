package com.swiftbeard.Chapter1.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.swiftbeard.Chapter1.entities.Person;
import com.swiftbeard.Chapter1.entities.PersonDTO;
import com.swiftbeard.Chapter1.entities.PersonProjection;
import com.swiftbeard.Chapter1.repositories.PersonRepository;
import com.swiftbeard.Chapter1.service.DBAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    //PROPERTIES
    @Autowired PersonRepository personRepository;
    //================================================================
// SELECT PERSON BY NAME AGE
//================================================================
    @RequestMapping("SelectPerson")
    Person selectPerson() {
        Person person = personRepository.selectPerson("John", 20);
        return person;
    }
    //================================================================
// INSERT PERSON
//================================================================
    @RequestMapping("InsertPerson")
    String insertPerson() {
        Integer insertedRecords = personRepository.insertPerson("John", 20);
        return insertedRecords + " Records Inserted";
    }
    //================================================================
// UPDATE PERSON
//================================================================
    @RequestMapping("UpdatePerson")
    String updatePerson() {
        Integer updatedRecords = personRepository.updatePerson("John", 200);
        return updatedRecords + " Records Updated";
    }
    //================================================================
// DELETE PERSON
//================================================================
    @RequestMapping("DeletePerson")
    String deletePerson() {
        Integer deletedRecords = personRepository.deletePerson("John");
        return deletedRecords + " Records Deleted";
    }
}