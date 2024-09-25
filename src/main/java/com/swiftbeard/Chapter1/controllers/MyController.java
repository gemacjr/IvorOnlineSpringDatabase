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
import java.util.List;

@RestController
public class MyController {
    //PROPERTIES
    @Autowired
    AuthorRepository authorRepository;
    @PersistenceContext
    EntityManager entityManager;
    //================================================================
// SELECT AUTHOR
//================================================================
    @RequestMapping("SelectAuthor")
    Author selectAuthor() throws JsonProcessingException {
// SELECT AUTHOR USING REPOSITORY THROWS ERROR:
// "Cannot create TypedQuery for query with more than one return"
// This is why in this tutorial we are using createNativeQuery() instead
// Object[] objectArray = (Object[]) query.getSingleResult(); //THROWS ERROR
//CREATE QUERY
        Query query = entityManager.createNamedQuery("Author.selectAuthorByName");
        query.setParameter("name", "John");
//SELECT AUTHOR
        Object[] result = (Object[]) query.getSingleResult();
        Author author = (Author) result[0];
        Book book = (Book) result[1];
//CONVERT OBJECTS TO JSON
        String resultJSON = new ObjectMapper().writeValueAsString(result);
        String authorJSON = new ObjectMapper().writeValueAsString(author);
        String bookJSON = new ObjectMapper().writeValueAsString(book);
//DISPLAY JSON
        System.out.println("Object[] = " + resultJSON);
        System.out.println("Author = " + authorJSON);
        System.out.println("Book = " + bookJSON);
//RETURN PERSON
        return author;
    }
}