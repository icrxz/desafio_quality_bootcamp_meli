package com.meli.testing.desafioquality.service;

import com.meli.testing.desafioquality.dto.mapper.PropertyMapper;
import com.meli.testing.desafioquality.dto.property.PropertyDTO;
import com.meli.testing.desafioquality.dto.property.PropertyM2DTO;
import com.meli.testing.desafioquality.dto.property.PropertyRoomsM2DTO;
import com.meli.testing.desafioquality.dto.property.PropertyValueDTO;
import com.meli.testing.desafioquality.dto.room.RoomMt2DTO;
import com.meli.testing.desafioquality.entity.District;
import com.meli.testing.desafioquality.entity.Property;
import com.meli.testing.desafioquality.exception.PropertyNotFoundException;
import com.meli.testing.desafioquality.form.PropertyForm;
import com.meli.testing.desafioquality.repository.PropertyRepository;
import com.meli.testing.desafioquality.utils.CalculateArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;
    private final DistrictService districtService;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository, DistrictService districtService) {
        this.propertyRepository = propertyRepository;
        this.districtService = districtService;
    }

    public Property findPropertyById(long id) {
        Property property = this.propertyRepository.findById(id).stream().findFirst().orElse(null);

        if (property == null) {
            throw new PropertyNotFoundException("Propriedade não encontrada");
        }

        return property;
    }

    public PropertyRoomsM2DTO calculateAreaPerRoom (long id) {
        Property property = findPropertyById(id);

        List<RoomMt2DTO> listRooms = property
                .getRooms()
                .stream()
                .map(RoomMt2DTO::new)
                .collect(Collectors.toList());

        return PropertyMapper.convert(property, listRooms);
    }

    public PropertyM2DTO calculateArea(long id) {
        Property property = findPropertyById(id);

        Double propertyM2 = CalculateArea.calculateProperty(property);

        return new PropertyM2DTO(property.getName(), propertyM2);
    }

    public PropertyDTO createProperty(PropertyForm propertyForm) {
        District district = districtService.getDistrictById(propertyForm.getProp_district_id());

        Property newProperty = PropertyMapper.convert(propertyForm, district);
        Property createdProperty = propertyRepository.save(newProperty);

        return PropertyMapper.convert(createdProperty);
    }

    public RoomMt2DTO getBiggestRoom(long id) {
        PropertyRoomsM2DTO propertyRooms = calculateAreaPerRoom(id);
        AtomicReference<RoomMt2DTO> roomMt = new AtomicReference<>();
        AtomicReference<Double> big = new AtomicReference<>((double) Integer.MIN_VALUE);

        propertyRooms.getRooms().forEach(room -> {
            if (room.getRoom_mt2() > big.get()) {
                roomMt.set(room);
                big.set(room.getRoom_mt2());
            }
        });

        return roomMt.get();
    }

    public List<PropertyDTO> getAllProperties() {
        return PropertyMapper.convert(propertyRepository.findAll());
    }

    public PropertyValueDTO getPropertyValue(long id) {
        Property property = findPropertyById(id);

        Double propertyArea = CalculateArea.calculateProperty(property);
        BigDecimal propValue = property.getDistrict().getValue_m2().multiply(BigDecimal.valueOf(propertyArea));

        return new PropertyValueDTO(property.getName(), propertyArea, propValue);
    }
}
