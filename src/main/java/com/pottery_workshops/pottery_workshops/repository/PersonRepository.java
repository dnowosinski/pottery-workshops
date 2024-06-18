package com.pottery_workshops.pottery_workshops.repository;

import com.pottery_workshops.pottery_workshops.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
