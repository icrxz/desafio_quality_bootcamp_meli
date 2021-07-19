package com.meli.testing.desafioquality.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.meli.testing.desafioquality.entity.District;
import com.meli.testing.desafioquality.entity.Property;
import com.meli.testing.desafioquality.entity.Room;
import com.meli.testing.desafioquality.mocks.PropertyMock;
import com.meli.testing.desafioquality.repository.PropertyRepository;
import com.meli.testing.desafioquality.service.DistrictService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.meli.testing.desafioquality.service.PropertyService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class PropertyControllerTest {

	@Autowired
	private MockMvc mock;

	@MockBean
	private PropertyRepository propertyRepository;

	@BeforeEach
	public void init() {
		this.propertyRepository.deleteAll();
	}

	@Test
	@DisplayName("should return property m2 if suceeds")
	public void checkinResultPropertyCalculationM2() throws Exception {
		given(propertyRepository.findById(1L)).willReturn(java.util.Optional.of(PropertyMock.create()));

		mock.perform(get("/property/calculate-m2/{id}", 1L))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.prop_m2").value(200));
	}

	@Test
	public void PropertyServiceIntTestCheckinResultAreaCalculationValueRight() throws Exception {

		mock.perform(get("/property/calculate-m2/{id}", 1L))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.prop_m2").value(1590.0));
	}
	
	@Test
	public void PropertyServiceIntTestCheckinResultPropertyCalculationM2IdIncorrectPropertyNotFoundExceptionMessageError() throws Exception {

		mock.perform(get("/property/calculate-m2/{id}", 0L))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.message").value("Propriedade não encontrada"));
	}


	@Test
	@DisplayName("should return a property value if succeeds")
	public void shouldReturnPropertyValue() throws Exception {
		// arrange
		given(propertyRepository.findById(1L)).willReturn(java.util.Optional.of(PropertyMock.create()));

		mock.perform(get("/property/value-property/{id}", 1L))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith("application/json"))
				.andExpect(jsonPath("$.prop_value").value(20000.0));
	}

	@Test
	@DisplayName("should throw if property are not found")
	public void shouldThrowsIfPropertyAreNotFound() throws Exception {
		mock.perform(get("/property/value-property/{id}", 1L))
				.andExpect(status().isBadRequest())
				.andExpect(content().contentTypeCompatibleWith("application/json"))
				.andExpect(jsonPath("$.message").value("Propriedade não encontrada"));
	}
}
