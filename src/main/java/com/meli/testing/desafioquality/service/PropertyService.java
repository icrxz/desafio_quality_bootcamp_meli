package com.meli.testing.desafioquality.service;

import com.meli.testing.desafioquality.entity.Property;
import com.meli.testing.desafioquality.exception.PropertyNotFoundException;
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

    public Property findPropertyById(long id) {
        Property property = this.propertyRepository.findById(id).stream().findFirst().orElse(null);
        if (property == null) {
            throw new PropertyNotFoundException("Propriedade não encontrada");
        }
        return property;
    }
}
