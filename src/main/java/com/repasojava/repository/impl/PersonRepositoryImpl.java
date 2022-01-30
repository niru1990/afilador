package com.repasojava.repository.impl;

import com.repasojava.dto.Person;
import com.repasojava.repository.PersonRepository;
import com.repasojava.rowmapper.PersonRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public PersonRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Person create(Person person) {
        return new Person();
    }

    public Person update(Person person) {
        return new Person();
    }

    public void delete(int id) {
        String sql = "DELETE FROM person WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.update(sql, params);
        //return true;
    }

    public Person get(int id) {
        String sql = "SELECT * FROM person WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        Person person = jdbcTemplate.queryForObject(sql, params, new PersonRowMapper());
        return person;
    }

    public List<Person> getAll() {
        String sql = "SELECT * FROM person";
        List<Person> personList = jdbcTemplate.query(sql, new PersonRowMapper());
        return personList;
    }
}
