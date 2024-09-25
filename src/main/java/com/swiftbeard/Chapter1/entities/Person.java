package com.swiftbeard.Chapter1.entities;

import javax.persistence.*;

@SqlResultSetMapping(
        name = "PersonMapping",
        columns = {
                @ColumnResult(name = "name"), //"John"
                @ColumnResult(name = "greet") //"John is 20"
        }
)
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public Integer age;
}