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
    @PersistenceContext
    EntityManager entityManager;
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        //NATIVE QUERY
        String insert = "INSERT INTO PERSON (name, age) VALUES (:name, :age)";
        Query query = entityManager.createNativeQuery(insert);
        query.setParameter("name", "John");
        query.setParameter("age" , 20 );
//INSERT PERSON
        query.executeUpdate();
    }
}