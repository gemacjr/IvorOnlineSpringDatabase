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
    @Autowired DBAccess dbAccess;
    //================================================================
// SELECT PERSON
//================================================================
    @RequestMapping("SelectPerson")
   public Person selectPerson() {
        Person person = dbAccess.selectPerson();
        return person;
    }
    //================================================================
// INSERT PERSON
//================================================================
    @Transactional
    @RequestMapping("InsertPerson")
    public String insertPerson() {
        Integer insertedRecords = dbAccess.insertPerson();
        return insertedRecords + " Records Inserted";
    }
    //================================================================
// UPDATE PERSON
//================================================================
    @RequestMapping("UpdatePerson")
   public String updatePerson() {
        Integer updatedRecords = dbAccess.updatePerson();
        return updatedRecords + " Records Updated";
    }
    //================================================================
// DELETE PERSON
//================================================================
    @RequestMapping("DeletePerson")
   public String deletePerson() {
        Integer deletedRecords = dbAccess.deletePerson();
        return deletedRecords + " Records Deleted";
    }
}