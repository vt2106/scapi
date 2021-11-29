package com.scapi.ShapeCalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.scapi.controller.ShapeController;
import com.scapi.shape.Shape;

public class ShapeCleanUpTest {
	
	@Test
	@DisplayName("CleanUp method test")
	void test() {
		Shape shape = new Shape();
		shape.setShape("rec TA ng l e");
		assertThat(shape.getShape()).isEqualTo("rectangle");
	}
}
