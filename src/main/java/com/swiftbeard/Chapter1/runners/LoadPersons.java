package com.swiftbeard.Chapter1.runners;


import com.swiftbeard.Chapter1.entities.Person;
import com.swiftbeard.Chapter1.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class LoadPersons implements CommandLineRunner {
    @Autowired PersonRepository personRepository;
    //================================================================
// RUN
//================================================================
    @Override
    @Transactional
    public void run(String... args) {
        personRepository.save(new Person("John" , 20));
        personRepository.save(new Person("John" , 21));
        personRepository.save(new Person("Bill" , 30));
        personRepository.save(new Person("Nancy", 40));
        personRepository.save(new Person("Susan", 50));
    }
}