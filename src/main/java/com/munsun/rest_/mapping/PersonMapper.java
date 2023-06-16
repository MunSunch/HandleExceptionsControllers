package com.munsun.rest_.mapping;

import com.munsun.rest_.bussiness.entity.Person;
import com.munsun.rest_.dto.PersonDtoIn;
import com.munsun.rest_.dto.PersonDtoOut;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    private ModelMapper mapper;

    @Autowired
    public PersonMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public PersonDtoOut toDto(Person person) {
        return mapper.map(person, PersonDtoOut.class);
    }

    public Person toEntity(PersonDtoIn personDtoIn) {
        return mapper.map(personDtoIn, Person.class);
    }
}
