package com.example.spring.with.mongo.services;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.with.mongo.Modules.Person;
import com.example.spring.with.mongo.repository.PersonRepository;

@Service
@Transactional
public class PersonServicesimpl implements PersonServices {
	
	@Autowired
	PersonRepository personRepository;

	/*Create person's details in Database*/
	@Override
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	/*Fetch data using person's ID*/
	@Override
	public Person getPersonDetailsById(int id) {
		return personRepository.findById(id).get();
	}

	/*Delete person data using id*/
	@Override
	public void deletePersonDetailsById(int id) {
	Person person = personRepository.findById(id).get();
	int idValue = person.getPersonId();
	if(idValue !=0) {
		personRepository.deleteById(id);
	}
	}

	/*Update person details*/
	@Override
	public Person upatePersonDetailsById(Person person, int id ) {
	 Person dbPersonDetails = 	personRepository.findById(id).get();
	 
	 if(Objects.nonNull(dbPersonDetails.getPersonName()) && !"".equalsIgnoreCase(person.getPersonName())) {
		 dbPersonDetails.setPersonName(person.getPersonName());
	 }
	 if(Objects.nonNull(dbPersonDetails.getPersonAddress()) && !"".equalsIgnoreCase(person.getPersonAddress())) {
		 dbPersonDetails.setPersonAddress(person.getPersonAddress());
	 }
	 if(Objects.nonNull(dbPersonDetails.getPersonSalary()) && !"".equalsIgnoreCase(person.getPersonSalary())) {
		 dbPersonDetails.setPersonSalary(person.getPersonSalary());
	 }
		return personRepository.save(dbPersonDetails);
	}

}
