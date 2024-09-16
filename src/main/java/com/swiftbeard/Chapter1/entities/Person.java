package com.swiftbeard.Chapter1.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Person {
    //PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public Integer age;
    //CONSTRUCTORS
    public Person() {} //Requiered by @Entity
    public Person(String name, Integer age) { //For loading data inside LoadPersons.java
        this.name = name;
        this.age = age;
    }


}