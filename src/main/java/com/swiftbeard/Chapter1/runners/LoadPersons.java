package com.swiftbeard.Chapter1.runners;

import com.swiftbeard.Chapter1.entities.Address;
import com.swiftbeard.Chapter1.entities.Person;
import com.swiftbeard.Chapter1.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
public class LoadPersons implements CommandLineRunner {
    //PROPERTIES
    @Autowired
    PersonRepository personRepository;
    //================================================================
// RUN
//================================================================
    @Override
    @Transactional
    public void run(String... args) {
        personRepository.deleteAll();
        personRepository.save(new Person("John","Doe", 20));
        personRepository.save(new Person("Bill", "Smith", 40));
    }
}