package com.swiftbeard.Chapter1.entities;

public class PersonDTO {
    public String name;
    public Integer age;

    //CONSTRUCTORS
    public PersonDTO() {}
    public PersonDTO(String name, Integer age) { //Used by Query
        this.name = name;
        this.age = age;
    }
}
