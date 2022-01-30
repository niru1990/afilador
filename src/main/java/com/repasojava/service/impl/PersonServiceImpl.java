package com.repasojava.service.impl;

import com.repasojava.dto.Person;
import com.repasojava.repository.impl.PersonRepositoryImpl;
import com.repasojava.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepositoryImpl personRepository;

    public PersonServiceImpl(PersonRepositoryImpl personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson(Person person) {
        return personRepository.create(person);
    }

    public Person updatePerson(Person person) {
        return personRepository.update(person);
    }

    public void deletePerson(int id) {
        personRepository.delete(id);
    }

    public Person getPerson(int id) {
        return personRepository.get(id);
    }

    public List<Person> getAllPerson() {
        return personRepository.getAll();
    }

}
