package com.swiftbeard.Chapter1.service;

import com.swiftbeard.Chapter1.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.swiftbeard.Chapter1.entities.Person;
import javax.persistence.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class DBAccess {
    //PROPERTIES
    @PersistenceContext
    EntityManager entityManager;
    //================================================================
// SELECT PERSON
//================================================================
    public Person selectPerson() {
//REFERENCE QUERY USING ENTITY MANAGER
        Query query = entityManager.createNamedQuery("Person.selectPerson");
        query.setParameter(1, "John");
        query.setParameter(2 , 20);
//SELECT PERSON
        Person person = (Person) query.getSingleResult();
//RETURN
        return person;
    }
    //================================================================
// UPDATE PERSON
//================================================================
    @Transactional
    public Integer updatePerson() {
//REFERENCE QUERY USING ENTITY MANAGER
        Query query = entityManager.createNamedQuery("Person.updatePerson");
        query.setParameter("name" , "John");
        query.setParameter("newAge", 200);
//UPDATE PERSON
        Integer updatedRecords = query.executeUpdate();
//RETURN
        return updatedRecords;
    }
    //================================================================
// DELETE PERSON
//================================================================
    @Transactional
    public Integer deletePerson() {
//REFERENCE QUERY USING ENTITY MANAGER
        Query query = entityManager.createNamedQuery("Person.deletePerson");
        query.setParameter("name", "John");
        Integer deletedRecords = query.executeUpdate();
//RETURN
        return deletedRecords;
    }
}
