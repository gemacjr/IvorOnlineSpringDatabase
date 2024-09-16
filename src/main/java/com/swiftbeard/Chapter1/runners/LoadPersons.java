package com.swiftbeard.Chapter1.runners;


import com.swiftbeard.Chapter1.entities.Person;
import com.swiftbeard.Chapter1.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class LoadPersons implements CommandLineRunner {
    //PROPERTIES
    @Autowired PersonRepository personRepository;
    @Override
    @Transactional
    public void run(String... args) throws Exception {
//CREATE PERSON
        Person person = new Person();
        person.name = "John";
        person.age = 20;
//SAVE PERSON
        personRepository.save(person);
    }
}