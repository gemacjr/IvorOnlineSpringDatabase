package com.swiftbeard.Chapter1.controllers;

import com.swiftbeard.Chapter1.entities.PersonProjection;
import com.swiftbeard.Chapter1.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyController {
    //PROPERTIES
    @Autowired PersonRepository personRepository;
    //================================================================
// FIND PERSON PROJECTION BY NAME
//================================================================
    @RequestMapping("FindPersonProjectionByName")
    PersonProjection findPersonProjectionByName() {
//GET PROJECTION FROM DB
        PersonProjection personProjection = personRepository.findPersonProjectionByFirstName("John");
//GET PROJECTION PROPERTIES
        String fullName = personProjection.getFullName();
        System.out.println("Hello " + fullName);
//RETURN PROJECTION
        return personProjection;
    }
}
