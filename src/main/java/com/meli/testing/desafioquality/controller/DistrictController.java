package com.meli.testing.desafioquality.controller;

import com.meli.testing.desafioquality.dto.DistrictDTO;
import com.meli.testing.desafioquality.form.DistrictForm;
import com.meli.testing.desafioquality.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictController {
    private final DistrictService districtService;

    @Autowired
    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @PostMapping
    public ResponseEntity<DistrictDTO> createDistrict(@RequestBody @Valid DistrictForm districtForm) {
        DistrictDTO newDistrict = districtService.createDistrict(districtForm);

        return new ResponseEntity(newDistrict, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DistrictDTO>> getListDistrict() {
        List<DistrictDTO> districtList = districtService.getAllDistrict();

        return new ResponseEntity(districtList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<DistrictDTO>> getDistrict(@PathVariable Long id) {
        DistrictDTO districtList = districtService.getDistrict(id);

        return new ResponseEntity(districtList, HttpStatus.OK);
    }
}
