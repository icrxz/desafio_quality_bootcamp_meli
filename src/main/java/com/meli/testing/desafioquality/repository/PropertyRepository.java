package com.meli.testing.desafioquality.repository;

import com.meli.testing.desafioquality.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
