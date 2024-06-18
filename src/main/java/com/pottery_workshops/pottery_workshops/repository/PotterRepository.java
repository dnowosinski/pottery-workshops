package com.pottery_workshops.pottery_workshops.repository;

import com.pottery_workshops.pottery_workshops.model.Potter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PotterRepository extends JpaRepository<Potter, Long> {
}
