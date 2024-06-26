package com.example.spring.with.mongo.Modules;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "person")
public class Person {
	
	@Id
	private int personId;
	private String personName;
	private String PersonAddress;
	private String personSalary;
	

}
