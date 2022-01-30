package com.repasojava.repository;

import com.repasojava.dto.Person;
import com.repasojava.rowmapper.PersonRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PersonRepository {

    Person create(Person person);

    Person update(Person person);

    void delete(int id);

    Person get(int id);

    List<Person> getAll();

}
