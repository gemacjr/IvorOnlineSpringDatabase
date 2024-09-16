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
    @RequestMapping("ReturnPersonProjection")
    PersonProjection returnPersonProjection() {
        PersonProjection personView = personRepository.returnPersonProjection();
        return personView;
    }
}