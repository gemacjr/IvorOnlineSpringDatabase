package com.swiftbeard.Chapter1.controllers;

import com.swiftbeard.Chapter1.entities.Person;
import com.swiftbeard.Chapter1.entities.PersonDTO;
import com.swiftbeard.Chapter1.entities.PersonProjection;
import com.swiftbeard.Chapter1.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    //PROPERTIES
    @Autowired PersonRepository personRepository;
    //================================================================
// SELECT PERSON
//================================================================
    @RequestMapping("SelectPerson")
    Person selectPerson() {
        Person person = personRepository.selectPerson("John", 20);
        return person;
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