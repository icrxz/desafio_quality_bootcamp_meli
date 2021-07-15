package com.meli.testing.desafioquality.repository;

import com.meli.testing.desafioquality.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
}
