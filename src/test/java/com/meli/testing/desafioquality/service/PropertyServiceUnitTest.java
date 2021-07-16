package com.meli.testing.desafioquality.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import com.meli.testing.desafioquality.dto.property.PropertyM2DTO;
import com.meli.testing.desafioquality.entity.District;
import com.meli.testing.desafioquality.entity.Property;
import com.meli.testing.desafioquality.entity.Room;
import com.meli.testing.desafioquality.exception.PropertyNotFoundException;
import com.meli.testing.desafioquality.mocks.PropertyMock;
import com.meli.testing.desafioquality.repository.PropertyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceUnitTest {

	private PropertyService propertyService;

	@Mock
	private DistrictService districtService;

	@Mock
	private PropertyRepository propertyRepository;

	@BeforeEach
	public void setUp() throws Exception {
		propertyRepository.deleteAll();
		propertyService = new PropertyService(propertyRepository, districtService);
	}

	@Test
	@DisplayName("should return a DTO if calculate value succeeds")
	void testGetPropertyValue() {
		// arrange
		given(propertyRepository.findById(1L)).willReturn(java.util.Optional.of(PropertyMock.create()));

		// act and assert
		PropertyM2DTO propertyM2DTO = propertyService.getPropertyValue(1L);
		assertThat(propertyM2DTO.getProp_value()).isEqualByComparingTo(new BigDecimal(2000000));
	}

	@Test
	@DisplayName("should throws if property are not found")
	void testGetPropertyValueThrowsNotFound() throws Exception{
		Throwable exception = assertThrows(PropertyNotFoundException.class, () -> propertyService.getPropertyValue(1L));
		assertEquals("Propriedade não encontrada", exception.getMessage());
	}
}
