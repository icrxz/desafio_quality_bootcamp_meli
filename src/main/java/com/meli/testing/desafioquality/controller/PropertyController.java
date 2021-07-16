package com.meli.testing.desafioquality.controller;

import com.meli.testing.desafioquality.dto.property.PropertyDTO;
import com.meli.testing.desafioquality.dto.property.PropertyM2DTO;
import com.meli.testing.desafioquality.dto.property.PropertyRoomsM2DTO;
import com.meli.testing.desafioquality.form.PropertyForm;
import com.meli.testing.desafioquality.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {
    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<PropertyDTO> createProperty(@Valid @RequestBody PropertyForm propertyForm) {
        return new ResponseEntity<>(this.propertyService.createProperty(propertyForm), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        return new ResponseEntity<>(this.propertyService.getAllProperties(), HttpStatus.OK);
    }

    @GetMapping("/calculate-room-m2/{id}")
    public ResponseEntity<PropertyRoomsM2DTO> calculateRoomM2(@PathVariable long id) {
        return new ResponseEntity<>(this.propertyService.calculateAreaPerRoom(id), HttpStatus.OK);
    }

    @GetMapping("/calculate-m2/{id}")
    public ResponseEntity<PropertyM2DTO> calculateArea(@PathVariable long id) {
        return new ResponseEntity<>(this.propertyService.calculateArea(id), HttpStatus.OK);
    }

    @GetMapping("/value-property/{id}")
    public ResponseEntity<PropertyM2DTO> getPropertyValue(@PathVariable long id) {
        return new ResponseEntity<>(this.propertyService.getPropertyValue(id), HttpStatus.OK);
    }
}
