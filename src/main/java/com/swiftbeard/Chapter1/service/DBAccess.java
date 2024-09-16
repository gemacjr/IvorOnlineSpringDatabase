package com.swiftbeard.Chapter1.service;

import com.swiftbeard.Chapter1.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.swiftbeard.Chapter1.entities.Person;

@Service
public class DBAccess {
    @Autowired
    PersonRepository personRepository;
    //================================================================
// SELECT PERSON BY NAME AGE
//================================================================
    public Person selectPersonByNameAge() {
        Person person = personRepository.selectPerson("John", 20);
        return person;
    }
    //================================================================
// UPDATE PERSON
//================================================================
    @Transactional
    public Integer updatePerson() {
        Integer updatedRecords = personRepository.updatePerson("John", 200);
        return updatedRecords;
    }
    //================================================================
// DELETE PERSON
//================================================================
    @Transactional
    public Integer deletePerson() {
        Integer deletedRecords = personRepository.deletePerson("John");
        return deletedRecords;
    }
}
