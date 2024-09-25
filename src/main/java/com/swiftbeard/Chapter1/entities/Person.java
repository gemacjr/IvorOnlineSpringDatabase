package com.swiftbeard.Chapter1.entities;


import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedNativeQuery(
        name = "Person.returnPerson",
        query = "SELECT * FROM Person WHERE name = :name AND age = :age"
        ,
        resultClass = Person.class
)
@NamedNativeQuery(
        name = "Person.returnArray",
        query = "SELECT name, age FROM Person WHERE name = :name AND age = :age"
)
@NamedNativeQuery(
        name = "Person.returnString",
        query = "SELECT name, age FROM Person WHERE name = :name AND age = :age"
)
@NamedNativeQuery(
        name = "Person.returnScalar",
        query = "SELECT age FROM Person WHERE name = :name AND age = :age"
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