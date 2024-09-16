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
// RETURN JSON RECORD
//================================================================
// {"name":"John","age":20}
    @RequestMapping("ReturnJSONRecord")
    String returnJSONRecord() {
        String json = personRepository.returnJSONRecord();
        return json;
    }
    //================================================================
// RETURN JSON ARRAY
//================================================================
// [{"name":"John","age":20}, {"name":"John","age":21}]
    @RequestMapping("ReturnJSONArray")
    String returnJSONArray() {
        String json = personRepository.returnJSONArray();
        return json;
    }
}