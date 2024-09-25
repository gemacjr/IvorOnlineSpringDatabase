package com.swiftbeard.Chapter1.entities;

import javax.persistence.*;

@SqlResultSetMapping(
        name = "PersonMapping"
        ,
        entities = @EntityResult(
                entityClass = Person.class,
                fields = {
                        @FieldResult(name = "id" , column = "id" ), //All Columns must be mapped
                        @FieldResult(name = "name", column = "authorName"),
                        @FieldResult(name = "age" , column = "authorAge" )
                }
        )
)
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public Integer age;
}