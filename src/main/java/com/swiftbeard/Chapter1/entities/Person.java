package com.swiftbeard.Chapter1.entities;


import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedNativeQuery(
        name = "Person.returnPersonDTO"
        ,
        query = "SELECT name, age FROM Person WHERE name = :name"
)
@Entity
public class Person {

    //PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String  name;
    public Integer age;

}