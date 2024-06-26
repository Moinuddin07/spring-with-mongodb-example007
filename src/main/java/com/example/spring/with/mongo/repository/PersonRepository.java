package com.example.spring.with.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.with.mongo.Modules.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, Integer>{

}
