package com.parkingapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	public void testCreationOfCar() {
		Car car = new Car("KA-01-HH-1234", "White");
	}

}
