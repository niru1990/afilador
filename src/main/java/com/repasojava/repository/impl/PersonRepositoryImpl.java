package com.repasojava.repository.impl;

import com.repasojava.dto.Person;
import com.repasojava.repository.PersonRepository;
import com.repasojava.rowmapper.PersonRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public PersonRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Person create(Person person) {

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO person (firstname, lastname, age) VALUES( ?, ?, ?)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("firstname", person.getFirstName());
        params.addValue("lastname", person.getLastName());
        params.addValue("edad", person.getAge());
        jdbcTemplate.update(sql, params,generatedKeyHolder);
        person.setId(Objects.requireNonNull(generatedKeyHolder.getKey()).intValue());
        return person;
    }

    public Person update(Person person) {
        String sql = "UPDATE person SET firstname =  :firstname,  lastname =  :lastname,  age = :edad WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", person.getId());
        params.put("firstname", person.getFirstName());
        params.put("lastname", person.getLastName());
        params.put("edad", person.getAge());
        jdbcTemplate.update(sql, params);
        return get(person.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM person WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.update(sql, params);
    }

    public Person get(int id) {
        String sql = "SELECT * FROM person WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.queryForObject(sql, params, new PersonRowMapper());
    }

    public List<Person> getAll() {
        String sql = "SELECT * FROM person";
        return jdbcTemplate.query(sql, new PersonRowMapper());
    }
}
