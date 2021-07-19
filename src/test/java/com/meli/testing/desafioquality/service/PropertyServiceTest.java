package com.meli.testing.desafioquality.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.meli.testing.desafioquality.entity.District;
import com.meli.testing.desafioquality.entity.Property;
import com.meli.testing.desafioquality.entity.Room;
import com.meli.testing.desafioquality.exception.PropertyNotFoundException;
import com.meli.testing.desafioquality.repository.PropertyRepository;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PropertyServiceTest {

	@InjectMocks
	PropertyService service;

	@Mock
	PropertyRepository repository;

	@BeforeEach
	private void init() {
		repository.deleteAll();
	}

	public void registerProperty() {
		District district = new District("any_district_name", new BigDecimal(100.00), null);
		List<Room> rooms = new ArrayList<>();
		Room room1 = new Room("Banheiro", 5.0, 5.0);
		Room room2 = new Room("Quarto", 15.0, 1.0);
		Room room3 = new Room("Sala", 20.0, 15.0);
		Room room4 = new Room("Cozinha", 25.0, 20.0);
		Room room5 = new Room("Suite", 30.0, 25.0);
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
		rooms.add(room4);
		rooms.add(room5);
		Property property = new Property("any_property_name", district, rooms);
		property.setId(1L);

		when(repository.findById(1L)).thenReturn(Optional.of(property));
	}

	@Test
	public void PropertyServiceUnitTestCheckinResultAreaCalculationValueRight() throws Exception {
		registerProperty();
		double result = (service.calculateArea(1L)).getProp_m2();

		Assertions.assertEquals(1590.0, result);
	}

	@Test
	public void PropertyServiceUnitTestCheckinResultAreaCalculationNameRight() throws Exception {
		registerProperty();

		String result = (service.calculateArea(1L)).getProp_name();

		Assertions.assertEquals("any_property_name", result);
	}
	
	@Test
	public void PropertyServiceUnitTestCheckinIdIncorrectPropertyNotFoundExceptionMessageError() throws Exception {
		registerProperty();
		String messageError = "Propriedade não encontrada";
		PropertyNotFoundException exception = Assertions.assertThrows(PropertyNotFoundException.class,() -> service.calculateArea(0L));
		assertEquals(messageError, exception.getMessage());
		
	}
	

}
