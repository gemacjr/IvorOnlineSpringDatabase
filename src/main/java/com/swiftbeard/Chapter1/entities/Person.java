package com.swiftbeard.Chapter1.entities;


import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedNativeQuery(
        name = "Person.selectPerson",
        query = "SELECT name, age FROM Person WHERE name = :name",
        resultSetMapping = "PersonDTOMapping"
)
@SqlResultSetMapping(
        name = "PersonDTOMapping",
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

    //PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String  name;
    public Integer age;

}