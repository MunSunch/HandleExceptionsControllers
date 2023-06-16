package com.munsun.rest_.web;

import com.munsun.rest_.bussiness.service.PersonService;
import com.munsun.rest_.dto.PersonDtoIn;
import com.munsun.rest_.dto.PersonDtoOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonRestController {
    private PersonService service;

    @Autowired
    public PersonRestController(PersonService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public PersonDtoOut savePerson(@RequestBody PersonDtoIn personDtoIn) {
        return service.save(personDtoIn);
    }

    @GetMapping("/get/{id}")
    public PersonDtoOut getPersonById(@PathVariable(name="id") int id) {
        return service.getById(id);
    }

//    @GetMapping("/get/{id}")
//    public PersonDtoOut getPersonById(@PathVariable(name="id") int id) {
//        try {
//            return service.getById(id);
//        } catch (PersonNotFoundException e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
//        }
//    }
}
