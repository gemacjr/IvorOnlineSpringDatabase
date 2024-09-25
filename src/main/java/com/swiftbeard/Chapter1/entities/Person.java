package com.swiftbeard.Chapter1.entities;


import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@SqlResultSetMapping(
        name = "PersonMapping",
        entities = @EntityResult(
                entityClass = Person.class,
                fields = {
                        @FieldResult(name = "id" , column = "id" ), //All Columns must be mapped
                        @FieldResult(name = "name", column = "authorName"),
                        @FieldResult(name = "age" , column = "authorAge" )
                }
        )
)
@NamedNativeQuery(
        name = "Person.selectPerson"
        ,
        query = "SELECT id, name AS authorName, age AS authorAge FROM Person WHERE name = :name"
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