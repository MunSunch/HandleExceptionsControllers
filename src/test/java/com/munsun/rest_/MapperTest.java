package com.munsun.rest_;

import com.munsun.rest_.bussiness.entity.Person;
import com.munsun.rest_.dto.PersonDtoIn;
import com.munsun.rest_.dto.PersonDtoOut;
import com.munsun.rest_.mapping.PersonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,
                classes = TestRestFullApplication.class)
public class MapperTest {
    @Autowired
    private PersonMapper mapper;

    @Test
    public void testToDto() {
        Person person = new Person();
        person.setName("test");
        person.setLastname("test");
        person.setAge(1);

        var expected = new PersonDtoOut();
        expected.setName("test");
        expected.setLastname("test");
        expected.setAge(1);

        var actual = mapper.toDto(person);

        assertAll(
                ()->assertEquals(expected.getName(), actual.getName()),
                ()->assertEquals(expected.getLastname(), actual.getLastname()),
                ()->assertEquals(expected.getAge(), actual.getAge())
        );
    }

    @Test
    public void testToEntity() {
        PersonDtoIn personDtoIn = new PersonDtoIn();
        personDtoIn.setName("test");
        personDtoIn.setLastname("test");
        personDtoIn.setAge(1);

        var expected = new PersonDtoOut();
        expected.setName("test");
        expected.setLastname("test");
        expected.setAge(1);

        var actual = mapper.toEntity(personDtoIn);

        assertAll(
                ()->assertEquals(expected.getName(), actual.getName()),
                ()->assertEquals(expected.getLastname(), actual.getLastname()),
                ()->assertEquals(expected.getAge(), actual.getAge())
        );
    }
}
