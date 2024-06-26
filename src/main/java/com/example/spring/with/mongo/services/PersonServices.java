package com.example.spring.with.mongo.services;


import com.example.spring.with.mongo.Modules.Person;

public interface PersonServices {
	
	Person savePerson(Person person);
	Person getPersonDetailsById(int id);
	void deletePersonDetailsById(int id);
	Person upatePersonDetailsById(Person person, int id);

}
