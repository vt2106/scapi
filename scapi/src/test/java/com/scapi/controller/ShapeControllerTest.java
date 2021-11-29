package com.scapi.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.scapi.repository.ShapeRepository;
import com.scapi.shape.Shape;

class ShapeControllerTest {
	@Autowired
	private ShapeRepository repo;

	@Test
	@DisplayName("Saving rectangle")
	void test() {
		Shape newShape = new Shape();
		newShape.setShape("rectangle");
		newShape.setDimension1(34);
		newShape.setDimension2(15);
		newShape.setId(25L);
		assertThat(newShape.getId()).isEqualTo(25L);
		assertThat(newShape.getShape()).isEqualTo("rectangle");
		assertThat(newShape.getDimension1()).isEqualTo(34);
		assertThat(newShape.getDimension2()).isEqualTo(15);
		assertThat(newShape.identifyShape(newShape)).isEqualTo(510);
	}

}
