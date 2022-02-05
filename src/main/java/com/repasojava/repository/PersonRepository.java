package com.repasojava.repository;

import com.repasojava.dto.Person;

import java.util.List;

public interface PersonRepository {

    Person create(Person person);

    Person update(Person person);

    void delete(int id);

    Person get(int id);

    List<Person> getAll();

}
