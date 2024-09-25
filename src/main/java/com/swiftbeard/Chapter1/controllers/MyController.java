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
// SELECT PERSON
//================================================================
    @RequestMapping("SelectPerson")
    PersonDTO selectPerson() throws JsonProcessingException {
//GET PERSON DTO
        PersonDTO personDTO = personRepository.selectPerson("John");
//DISPLAY PERSON DTO
        System.out.println(new ObjectMapper().writeValueAsString(personDTO));
//RETURN PERSON DTO
        return personDTO;
    }

}