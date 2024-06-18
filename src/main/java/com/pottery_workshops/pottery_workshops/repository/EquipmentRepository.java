package com.pottery_workshops.pottery_workshops.repository;

import com.pottery_workshops.pottery_workshops.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
