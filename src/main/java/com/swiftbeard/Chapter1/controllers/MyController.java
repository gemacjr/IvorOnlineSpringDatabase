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
    @Autowired DBAccess dbAccess;
    //================================================================
// SELECT PERSON
//================================================================
    @RequestMapping("SelectPerson")
    Person selectPerson() {
        Person person = dbAccess.selectPerson();
        return person;
    }
    //================================================================
// UPDATE PERSON
//================================================================
    @RequestMapping("UpdatePerson")
    String updatePerson() {
        Integer updatedRecords = dbAccess.updatePerson();
        return updatedRecords + " Records Updated";
    }
    //================================================================
// DELETE PERSON
//================================================================
    @RequestMapping("DeletePerson")
    String deletePerson() {
        Integer deletedRecords = dbAccess.deletePerson();
        return deletedRecords + " Records Deleted";
    }
}