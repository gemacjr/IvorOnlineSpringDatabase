package com.swiftbeard.Chapter1.entities;


import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery(
        name = "Person.returnEntity",
        query = "SELECT person FROM Person person WHERE person.name = :name"
)
@NamedQuery(
        name = "Person.returnObjectArray",
        query = "SELECT person.name, person.age FROM Person person WHERE person.name = :name"
)
@NamedQuery(
        name = "Person.returnString",
        query = "SELECT person.name, person.age FROM Person person WHERE person.name = :name"
)
@NamedQuery(
        name = "Person.returnScalar",
        query = "SELECT person.age FROM Person person WHERE person.name = :name"
)
@Entity
public class Person {
    //PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public Integer age;
}