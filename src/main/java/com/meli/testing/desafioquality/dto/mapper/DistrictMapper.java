package com.meli.testing.desafioquality.dto.mapper;

import com.meli.testing.desafioquality.dto.DistrictDTO;
import com.meli.testing.desafioquality.entity.District;
import com.meli.testing.desafioquality.form.DistrictForm;

import java.util.List;
import java.util.stream.Collectors;

public class DistrictMapper {
    public static District convert(DistrictForm districtForm) {
        District district = new District();

        district.setName(districtForm.getDistrict_name());
        district.setValue_m2(districtForm.getValue_district_m2());

        return district;
    }

    public static DistrictDTO convert(District district) {
        return new DistrictDTO(district);
    }

    public static List<DistrictDTO> convert(List<District> districtList) {
        return districtList.stream().map(DistrictDTO::new).collect(Collectors.toList());
    }
}
