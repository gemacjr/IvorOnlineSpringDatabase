package com.swiftbeard.Chapter1.entities;


import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery(
        name = "Person.selectPerson",
        query = "SELECT person FROM Person person WHERE person.name = ?1 AND person.age = ?2"
)
@NamedQuery(
        name = "Person.updatePerson",
        query = "UPDATE Person person SET person.age = :newAge WHERE person.name = :name"
)
@NamedQuery(
        name = "Person.deletePerson",
        query = "DELETE FROM Person person WHERE person.name = :name"
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