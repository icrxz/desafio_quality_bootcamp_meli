package com.meli.testing.desafioquality.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import com.meli.testing.desafioquality.dto.property.PropertyValueDTO;
import com.meli.testing.desafioquality.dto.room.RoomMt2DTO;
import com.meli.testing.desafioquality.exception.PropertyNotFoundException;
import com.meli.testing.desafioquality.mocks.PropertyMock;
import com.meli.testing.desafioquality.repository.PropertyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceUnitTest {

	//@InjectMocks
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
	void shouldTestGetPropertyValue() {
		// arrange
		given(propertyRepository.findById(1L)).willReturn(java.util.Optional.of(PropertyMock.create()));

		// act and assert
		PropertyValueDTO propertyValueDTO = propertyService.getPropertyValue(1L);
		assertThat(propertyValueDTO.getProp_value()).isEqualByComparingTo(new BigDecimal(50000.0));
	}

	@Test
	@DisplayName("should throws if property are not found")
	void shouldTestGetPropertyValueThrowsNotFound() throws Exception{
		Throwable exception = assertThrows(PropertyNotFoundException.class, () -> propertyService.getPropertyValue(1L));
		assertEquals("Propriedade n??o encontrada", exception.getMessage());
	}

	@Test
	@DisplayName("should return biggest room DTO")
	void shouldTestGetBiggestRoomValue() {
		given(propertyRepository.findById(1L)).willReturn(java.util.Optional.of(PropertyMock.create()));

		RoomMt2DTO roomMt2DTO = propertyService.getBiggestRoom(1L);

		assertThat(roomMt2DTO.getRoom_name()).isEqualTo("biggest_room");
		assertThat(roomMt2DTO.getRoom_mt2()).isEqualTo(300.0);
	}

	@Test
	@DisplayName("should not match wrong room")
	void shouldTestGetBiggestRoomValueNotMatch() {
		given(propertyRepository.findById(1L)).willReturn(java.util.Optional.of(PropertyMock.create()));

		RoomMt2DTO roomMt2DTO = propertyService.getBiggestRoom(1L);

		assertThat(roomMt2DTO.getRoom_name()).isNotEqualTo("any_description");
	}

	@Test
	public void PropertyServiceUnitTestCheckinResultAreaCalculationValueRight() throws Exception {
		given(propertyRepository.findById(1L)).willReturn(java.util.Optional.of(PropertyMock.createPropertyM2()));
		double result = (propertyService.calculateArea(1L)).getProp_m2();
		Assertions.assertEquals(1590.0, result);
	}

	@Test
	public void PropertyServiceUnitTestCheckinResultAreaCalculationNameRight() throws Exception {
		given(propertyRepository.findById(1L)).willReturn(java.util.Optional.of(PropertyMock.createPropertyM2()));
		String result = (propertyService.calculateArea(1L)).getProp_name();
		Assertions.assertEquals("any_property_name", result);
	}

	@Test
	@DisplayName("should throws if property are not found")
	public void PropertyServiceUnitTestCheckinIdIncorrectPropertyNotFoundExceptionMessageError() throws Exception {
		Throwable exception = assertThrows(PropertyNotFoundException.class, () -> propertyService.calculateArea(0L));
		assertEquals("Propriedade n??o encontrada", exception.getMessage());
	}
}
