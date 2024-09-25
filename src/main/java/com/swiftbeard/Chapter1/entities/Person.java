package com.swiftbeard.Chapter1.entities;


import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@SqlResultSetMapping(
        name = "PersonMapping",
        columns = {
                @ColumnResult(name = "name"), //"John"
                @ColumnResult(name = "greet") //"John is 20"
        }
)
@NamedNativeQuery(
        name = "Person.selectPerson",
        query = "SELECT id, name, age, name || ' is ' || age AS greet FROM Person WHERE name = :name"
        ,
        resultSetMapping = "PersonMapping"
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