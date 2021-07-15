package com.meli.testing.desafioquality.service;

import com.meli.testing.desafioquality.dto.DistrictDTO;
import com.meli.testing.desafioquality.dto.mapper.DistrictMapper;
import com.meli.testing.desafioquality.entity.District;
import com.meli.testing.desafioquality.exception.DistrictNotFoundException;
import com.meli.testing.desafioquality.form.DistrictForm;
import com.meli.testing.desafioquality.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {
    private final DistrictRepository districtRepository;

    @Autowired
    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public DistrictDTO getDistrict(Long id) {
        District district = districtRepository.findById(id).orElse(null);

        if (district == null)
            throw new DistrictNotFoundException("O bairro não foi encontrado.");

        return DistrictMapper.convert(district);
    }

    public DistrictDTO createDistrict(DistrictForm districtForm) {
        District newDistrict = DistrictMapper.convert(districtForm);

        District createdDistrict = districtRepository.save(newDistrict);

        return DistrictMapper.convert(createdDistrict);
    }

    public List<DistrictDTO> getAllDistrict() {
        return DistrictMapper.convert(districtRepository.findAll());
    }
}
