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
// RETURN PERSON
//================================================================
    @RequestMapping("ReturnPerson")
    Person returnPerson() {
        Person person = personRepository.returnPerson("John", 20);
        return person;
    }
    //================================================================
// RETURN ARRAY
//================================================================
    @RequestMapping("ReturnArray")
    Object[] returnArray() {
        Object[] array = (Object[]) personRepository.returnArray("John", 20);
        return array;
    }
    //================================================================
// RETURN STRING
//================================================================
    @RequestMapping("ReturnString")
    String returnString() {
        String nameAge = personRepository.returnString("John", 20);
        return nameAge;
    }
    //================================================================
// RETURN SCALAR
//================================================================
    @RequestMapping("ReturnScalar")
    Integer returnScalar() {
        Integer age = personRepository.returnScalar("John", 20);
        return age;
    }
}