package com.munsun.rest_.bussiness.service;

import com.munsun.rest_.bussiness.repository.PersonRepository;
import com.munsun.rest_.commons.exceptions.PersonNotFoundException;
import com.munsun.rest_.dto.PersonDtoIn;
import com.munsun.rest_.dto.PersonDtoOut;
import com.munsun.rest_.mapping.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository repository;
    private final PersonMapper mapper;

    @Autowired
    public PersonService(PersonRepository repository, PersonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public PersonDtoOut save(PersonDtoIn personDtoIn) {
        var person = mapper.toEntity(personDtoIn);
        var result = repository.save(person);
        return mapper.toDto(result);
    }

    public PersonDtoOut getById(int id) {
        var person = repository.findById((long)id).orElseThrow(
                ()->new PersonNotFoundException(id)
        );
        return mapper.toDto(person);
    }
}
