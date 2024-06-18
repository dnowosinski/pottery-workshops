package com.pottery_workshops.pottery_workshops.repository;

import com.pottery_workshops.pottery_workshops.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
