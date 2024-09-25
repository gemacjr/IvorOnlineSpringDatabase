package com.swiftbeard.Chapter1.repositories;

import com.swiftbeard.Chapter1.entities.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.*;

public interface PersonRepository extends CrudRepository<Person, Integer> {
//    Object[] selectPerson(String name);
}