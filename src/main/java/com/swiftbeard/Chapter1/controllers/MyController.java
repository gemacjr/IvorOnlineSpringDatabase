package com.swiftbeard.Chapter1.controllers;

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
// RETURN ENTITY
//================================================================
    @RequestMapping("ReturnEntity")
    Person returnEntity() {
        Person person = personRepository.returnEntity("John");
        return person;
    }
    //================================================================
// RETURN OBJECT ARRAY
//================================================================
    @RequestMapping("ReturnObjectArray")
    Object[] returnObjectArray() {
        Object[] objectArray = (Object[]) personRepository.returnObjectArray("John");
        return objectArray;
    }
    //================================================================
// RETURN STRING
//================================================================
    @RequestMapping("ReturnString")
    String returnString() {
        String nameAge = personRepository.returnString("John");
        return nameAge;
    }
    //================================================================
// RETURN SCALAR
//================================================================
    @RequestMapping("ReturnScalar")
    Integer returnScalar() {
        Integer age = personRepository.returnScalar("John");
        return age;
    }
}