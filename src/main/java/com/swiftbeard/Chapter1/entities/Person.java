package com.swiftbeard.Chapter1.entities;


import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
public class Person {
    //PROEPRTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public Integer age;
    //CONSTRUCTORS
    public Person() { } //Forced by @Entity
    public Person(String name, Integer age) { //To simplify PersonLoader
        this.name = name;
        this.age = age;
    }
}