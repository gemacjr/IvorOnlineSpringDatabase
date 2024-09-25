package com.swiftbeard.Chapter1.repositories;

import com.swiftbeard.Chapter1.entities.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface AuthorRepository extends CrudRepository<Author, Integer> {
    @Query(nativeQuery=true)
    Object[] selectAuthorByName(String name); //THROWS ERROR
}
