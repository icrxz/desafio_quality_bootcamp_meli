package com.meli.testing.desafioquality.service;

import com.meli.testing.desafioquality.dto.mapper.PropertyMapper;
import com.meli.testing.desafioquality.dto.property.PropertyDTO;
import com.meli.testing.desafioquality.dto.property.PropertyM2DTO;
import com.meli.testing.desafioquality.dto.property.PropertyRoomsM2DTO;
import com.meli.testing.desafioquality.dto.room.RoomMt2DTO;
import com.meli.testing.desafioquality.entity.District;
import com.meli.testing.desafioquality.entity.Property;
import com.meli.testing.desafioquality.exception.PropertyNotFoundException;
import com.meli.testing.desafioquality.form.PropertyForm;
import com.meli.testing.desafioquality.repository.PropertyRepository;
import com.meli.testing.desafioquality.utils.CalculateRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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
        List<RoomMt2DTO> listRooms = new ArrayList<>();
        property.getRooms().forEach(room -> listRooms.add(new RoomMt2DTO(room)));
        return PropertyMapper.convert(property, listRooms);
    }

    public PropertyM2DTO calculateArea(long id) {
        Property property = findPropertyById(id);
        Double propertym2 = property.getRooms().stream().mapToDouble(room -> CalculateRoom.calculateArea(room)).sum();
        return new PropertyM2DTO(property.getName(), propertym2);
    }

    public PropertyDTO createProperty(PropertyForm propertyForm) {
        District district = districtService.getDistrictById(propertyForm.getProp_district_id());

        Property newProperty = PropertyMapper.convert(propertyForm, district);
        Property createdProperty = propertyRepository.save(newProperty);
        return PropertyMapper.convert(createdProperty);
    }

    public RoomMt2DTO biggestRoom (long id) {
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

    public PropertyM2DTO getPropertyValue(long id) {
        Property property = findPropertyById(id);
        PropertyM2DTO propertyDTO = calculateArea(property.getId());
        propertyDTO.setProp_value(property.getDistrict().getValue_m2().multiply(new BigDecimal(propertyDTO.getProp_m2())));

        return propertyDTO;
    }
}
