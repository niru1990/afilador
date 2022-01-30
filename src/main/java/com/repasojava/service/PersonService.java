package com.repasojava.service;

import com.repasojava.dto.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);

    Person updatePerson(Person person);

    void deletePerson(int id);

    Person getPerson(int id);

    List<Person> getAllPerson();

}
