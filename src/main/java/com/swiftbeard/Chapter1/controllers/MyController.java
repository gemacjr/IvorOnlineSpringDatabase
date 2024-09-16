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
    @RequestMapping("NoParameters")
    Person noParameters() {
        Person person = personRepository.noParameters();
        return person;
    }
    //================================================================
// INDEXED PARAMETERS
//================================================================
    @RequestMapping("IndexedParameters")
    Person indexedParameters() {
        Person person = personRepository.indexedParameters("John", 20);
        return person;
    }
    //================================================================
// NAMED PARAMETERS
//================================================================
    @RequestMapping("NamedParameters")
    Person namedParameters() {
        Person person = personRepository.namedParameters("John", 20);
        return person;
    }
    //================================================================
// SELECT PERSON BY NAME AGE (Returns Single Entity)
//================================================================
    @RequestMapping("SelectPersonByNameAge")
    Person selectPersonByNameAge() {
        Person john = personRepository.selectPersonByNameAge("John", 20);
        return john;
    }
    //================================================================
// SELECT PERSONS BY NAME (Returns List)
//================================================================
    @RequestMapping("SelectPersonsByName")
    List<Person> selectPersonsByName() {
        List<Person> persons = personRepository.selectPersonsByName("John");
        return persons;
    }

    @RequestMapping("UpdatePersonsByName")
    String updatePersonsByName() {
        Integer recordsUpdated = personRepository.updatePersonsByName("John", 50); //New age
        return recordsUpdated + " Records Updated";
    }
    //================================================================
// DELETE PERSON BY NAME
//================================================================
    @RequestMapping("DeletePersonsByName")
    String deletePersonsByName() {
        Integer recordsDeleted = personRepository.deletePersonsByName("John");
        return recordsDeleted + " Records Deleted";
    }
    //=======================================================================================
// INSERT PERSON
//=======================================================================================
    @RequestMapping("InsertPerson")
    String insertPerson() {
        Integer recordsDeleted = personRepository.insertPerson("Jack", 100);
        return recordsDeleted + " Records Inserted";
    }
}