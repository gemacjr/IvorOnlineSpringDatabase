package com.swiftbeard.Chapter1.entities;

import javax.persistence.*;

@SqlResultSetMapping(
        name = "PersonViewMapping",
        classes = @ConstructorResult(
                targetClass = PersonDTO.class,
                columns = {
                        @ColumnResult(name = "name"),
                        @ColumnResult(name = "age" )
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