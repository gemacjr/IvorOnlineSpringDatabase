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
    @Autowired
    PersonRepository personRepository;


    @RequestMapping("ReturnPersonDTO")
    PersonDTO returnPersonDTO() throws JsonProcessingException {
//GET COLUMNS
        Object[] columns = (Object[]) personRepository.selectPerson("John"); //["John",20]
//DISPLAY COLUMNS
        String columnsJSON = new ObjectMapper().writeValueAsString(columns);
        System.out.println(columnsJSON);
//MAP COLUMNS INTO DTO
        PersonDTO personDTO = new PersonDTO();
        personDTO.name = (String) columns[0];
        personDTO.age = (Integer) columns[1];
//RETURN DTO
        return personDTO;

    }
}