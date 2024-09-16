package com.swiftbeard.Chapter1.entities;
import org.springframework.beans.factory.annotation.Value;

//Closed Projection returns subset of Properties from DB.
public interface PersonProjection {
    @Value("#{target.name + ' is ' + target.age + ' years old'}")
    String getExpression();
}
