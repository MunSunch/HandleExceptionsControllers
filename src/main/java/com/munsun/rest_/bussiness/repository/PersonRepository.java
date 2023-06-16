package com.munsun.rest_.bussiness.repository;

import com.munsun.rest_.bussiness.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}