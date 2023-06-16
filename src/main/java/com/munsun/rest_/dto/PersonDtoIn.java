package com.munsun.rest_.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PersonDtoIn {
    @JsonProperty("name")
    private String name;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("age")
    private int age;
}
