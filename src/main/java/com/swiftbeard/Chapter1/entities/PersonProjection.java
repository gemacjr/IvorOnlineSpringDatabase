package com.swiftbeard.Chapter1.entities;

//Closed Projection returns subset of Properties from DB.
public interface PersonProjection {
    //GETTERS
    String getName();
    Integer getAge ();
}
