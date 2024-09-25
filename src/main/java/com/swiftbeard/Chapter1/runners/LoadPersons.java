package com.swiftbeard.Chapter1.runners;


import com.swiftbeard.Chapter1.entities.*;
import com.swiftbeard.Chapter1.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class LoadPersons implements CommandLineRunner {
    //PROPERTIES
    @Autowired
    AuthorRepository authorRepository;
    //=======================================================================================
// RUN
//=======================================================================================
    @Override
    @Transactional
    public void run(String... args) {
//CREATE ADDRESS ENTITY
        Book book = new Book();
        book.title = "Dogs";
//CREATE AUTHOR ENTITY
        Author author = new Author();
        author.name = "John";
        author.age = 20;
        author.book = book;
//STORE AUTHOR/ADDRESS ENTITY INTO DB
        authorRepository.save(author);
    }
}