package com.swiftbeard.Chapter1.entities;

//Closed Projection returns subset of Properties from DB.
public interface PersonProjection {
    String getName();
    String getAge ();
}
