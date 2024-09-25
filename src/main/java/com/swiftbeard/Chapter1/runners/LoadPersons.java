package com.swiftbeard.Chapter1.runners;


import com.swiftbeard.Chapter1.entities.*;
import com.swiftbeard.Chapter1.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;


@Component
public class LoadPersons implements CommandLineRunner {
    @PersistenceContext
    EntityManager entityManager;
    //=======================================================================================
// RUN
//=======================================================================================
    @Override
    @Transactional
    public void run(String... args) throws Exception {
//INSERT PERSON
        String insert = "INSERT INTO PERSON (name, age) VALUES (:name, :age)";
        Query query = entityManager.createNativeQuery(insert);
        query.setParameter("name", "John");
        query.setParameter("age" , 20);
        query.executeUpdate();
    }
}