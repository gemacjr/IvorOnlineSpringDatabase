package com.swiftbeard.Chapter1.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.swiftbeard.Chapter1.entities.*;
import com.swiftbeard.Chapter1.repositories.*;
import com.swiftbeard.Chapter1.service.DBAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import javax.transaction.*;
import java.util.List;

@RestController
public class MyController {//PROPERTIES

    //PROPERTIES
    @PersistenceContext EntityManager entityManager;

    @RequestMapping("ReturnPersonDTO")
    PersonDTO returnPersonDTO() throws JsonProcessingException {
//CREATE QUERY
        String select = "SELECT name, age FROM Person WHERE name = :name";
        Query query = entityManager.createNativeQuery(select);
        query.setParameter("name", "John");
//EXECUTE QUERY (Returns Properties as Array Elements)
        Object[] columns = (Object[]) query.getSingleResult(); //["John",20]
//MAP ARRAY ELEMENTS INTO DTO PROPERTIES
        PersonDTO personDTO = new PersonDTO();
        personDTO.name = (String ) columns[0];
        personDTO.age = (Integer) columns[1];
//DISPLAY ARRAY ELEMENTS TO CONSOLE
        String columnsJSON = new ObjectMapper().writeValueAsString(columns); //["John",20]
        System.out.println(columnsJSON);
//RETURN DTO
        return personDTO;
    }
}