package com.meli.testing.desafioquality.service;

import com.meli.testing.desafioquality.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }
}
