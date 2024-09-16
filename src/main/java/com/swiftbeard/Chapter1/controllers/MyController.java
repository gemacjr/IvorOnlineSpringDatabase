package com.swiftbeard.Chapter1.controllers;

import com.swiftbeard.Chapter1.entities.AddressProjection;
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
// FIND PERSON PROJECTION BY NAME
//================================================================
    @RequestMapping("FindPersonProjectionByName")
    AddressProjection FindPersonProjectionByName() {
//GET PARENT AND CHILD PROJECTIONS FROM DB
        PersonProjection personProjection = personRepository.findVPersonProjectionByName("Sam");
        AddressProjection addressProjection = personProjection.getAddress();
//GET PROJECTION PROPERTIES
        String name = personProjection .getName();
        String city = addressProjection.getCity();
        System.out.println(name + " lives in " + city);
//RETURN PROJECTION
        return addressProjection;
    }
}