package com.repasojava.controller;

import com.repasojava.dto.Person;
import com.repasojava.service.impl.PersonServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
//Controlador -> Servicio -> Repositorio

    private final PersonServiceImpl service;

    public PersonController(PersonServiceImpl service) {
        this.service = service;
    }

    //Crear
    @PostMapping(value = "/person")
    public Person createPerson(@RequestBody Person person) {
        return service.createPerson(person);
    }

    //Eliminar
    @DeleteMapping(value = "/person/{id}")
    public void deletePerson(int id) {
        service.deletePerson(id);
    }

    //Modificar
    @PutMapping(value = "/person") //{id}
    public Person updatePerson(Person person) {
        return service.updatePerson(person);
    }

    //Traer
    @GetMapping(value = "/person/{id}")
    public Person getPerson(@PathVariable int id) {
        return service.getPerson(id);
    }

    @GetMapping(value = "/person")
    public List<Person> getAllPerson() {
        return service.getAllPerson();
    }

}