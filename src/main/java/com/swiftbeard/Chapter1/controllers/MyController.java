package com.swiftbeard.Chapter1.controllers;

import com.swiftbeard.Chapter1.entities.AddressProjection;
import com.swiftbeard.Chapter1.entities.Person;
import com.swiftbeard.Chapter1.entities.PersonDTO;
import com.swiftbeard.Chapter1.entities.PersonProjection;
import com.swiftbeard.Chapter1.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MyController {

    @Autowired
    PersonRepository personRepository;
    //================================================================
// FIND PERSON BY NAME
//================================================================
    @RequestMapping("FindPersonByName")
    Person findPersonByName() {
        Person person = personRepository.findByName("John", Person.class);
        return person;
    }
    //================================================================
// FIND PERSON PROJECTION BY NAME
//================================================================
    @RequestMapping("FindPersonProjectionByName")
    PersonProjection findPersonProjectionByName() {
        PersonProjection personView = personRepository.findByName("John", PersonProjection.class);
        return personView;
    }
    //================================================================
// FIND PERSON DTO BY NAME
//================================================================
    @RequestMapping("FindPersonDTOByName")
    PersonDTO findPersonDTOByName() {
        PersonDTO personDTO = personRepository.findByName("John", PersonDTO.class);
        return personDTO;
    }
}