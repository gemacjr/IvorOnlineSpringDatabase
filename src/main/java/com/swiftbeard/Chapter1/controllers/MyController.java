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

    //PROPERTIES
    @PersistenceContext
    EntityManager entityManager;

    @RequestMapping("SelectAuthor")
    Author selectAuthor() throws JsonProcessingException {
//CREATE QUERY
        String select =
                "SELECT author.id AS authorId, name, age, book_id, " + //Author
                        " book.id AS bookId, title " + //Book
                        "FROM Author " +
                        "JOIN Book ON book_id = book.id " + //Relationship
                        "WHERE name = :name ";
        Query query = entityManager.createNativeQuery(select, "AuthorBookMapping");
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