package com.munsun.rest_.bussiness.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="lastname")
    private String lastname;

    @Column(name = "age")
    private int age;
}
