package com.swiftbeard.Chapter1.entities;

import org.springframework.beans.factory.annotation.Value;
//Opened Projection returns value calculated from Properties. All Properties are returned from DB.
public interface PersonProjection {
    @Value("#{target.firstName + ' ' + target.lastName}") //SpEL - Spring Expression Language
    String getFullName();
}
