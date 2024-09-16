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
    @PersistenceContext EntityManager entityManager;
    //================================================================
// SELECT PERSON
//================================================================
    public Person selectPerson() {
//CREATE QUERY
        String select = "SELECT john FROM Person john WHERE john.name = :name AND john.age = :age";
        Query query = entityManager.createQuery(select, Person.class);
        query.setParameter("name", "John");
        query.setParameter("age" , 20);
//SELECT PERSON
        Person person = (Person) query.getSingleResult();
//RETURN PERSON
        return person;
    }
    //================================================================
// UPDATE PERSON
//================================================================
    @Transactional
    public Integer updatePerson() {
//CREATE QUERY
        String update = "UPDATE Person person SET person.age = :newAge WHERE person.name = :name";
        Query query = entityManager.createQuery(update);
        query.setParameter("name" , "John");
        query.setParameter("newAge", 200);
//INSERT PERSON
        Integer updatedRecords = query.executeUpdate();
//RETURN NUMBER OF INSERTED RECORDS
        return updatedRecords;
    }
    //================================================================
// DELETE PERSON
//================================================================
    @Transactional
    public Integer deletePerson() {
//CREATE QUERY
        String delete = "DELETE FROM Person person WHERE person.name = :name";
        Query query = entityManager.createQuery(delete);
        query.setParameter("name", "John");
//INSERT PERSON
        Integer deletedRecords = query.executeUpdate();
//RETURN NUMBER OF INSERTED RECORDS
        return deletedRecords;
    }
}
