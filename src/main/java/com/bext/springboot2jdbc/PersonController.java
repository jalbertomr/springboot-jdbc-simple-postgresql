package com.bext.springboot2jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping("/persons")
	public ResponseEntity<List<Person>> getAllPersons(){
		List<Person> persons = jdbcTemplate.query("SELECT * FROM PERSON", new BeanPropertyRowMapper(Person.class));
		return new ResponseEntity<>(persons, HttpStatus.OK);
	}
}
