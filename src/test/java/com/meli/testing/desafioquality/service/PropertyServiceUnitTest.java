package com.meli.testing.desafioquality.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import com.meli.testing.desafioquality.dto.property.PropertyValueDTO;
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
		PropertyValueDTO propertyValueDTO = propertyService.getPropertyValue(1L);
		assertThat(propertyValueDTO.getProp_value()).isEqualByComparingTo(new BigDecimal(20000.0));
	}

	@Test
	@DisplayName("should throws if property are not found")
	void testGetPropertyValueThrowsNotFound() throws Exception{
		Throwable exception = assertThrows(PropertyNotFoundException.class, () -> propertyService.getPropertyValue(1L));
		assertEquals("Propriedade não encontrada", exception.getMessage());
	}
}
