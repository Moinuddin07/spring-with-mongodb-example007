package com.example.spring.with.mongo.Controller;

import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.spring.with.mongo.Modules.Person;
import com.example.spring.with.mongo.services.PersonServices;

@RestController
public class PersonController {
	
	@Autowired
	PersonServices personServices;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/saveData" )
	public String saveDetials(@RequestBody Person person) {
	Person dbPerson = personServices.savePerson(person);
	log.info("Person details from database {}" + dbPerson );
	if(!Objects.toString(dbPerson).isEmpty()) {
		return "Person details added successfully";
	}
	 return "Person Details not added";
	}
	
	@PostMapping("/person/{id}")
	public Person fetchPersonDetails(@PathVariable int id){
		Person personDetails = personServices.getPersonDetailsById(id);
		if(!Objects.toString(personDetails).isEmpty()) {
			return personDetails;
		}
		return personDetails;
	}
	
	@DeleteMapping("/person/{id}")
	public String deletePersonDetails(@PathVariable int id ) {
		personServices.deletePersonDetailsById(id);
		return "Details deleted successfully";
	}
	
	@PutMapping("/person/{id}")
	public String updatePersonDetails(@RequestBody Person person, @PathVariable int id) {
		if(!personServices.upatePersonDetailsById(person,id).getClass().toString().isEmpty());
		return "Data updated successfully";
	}

}
