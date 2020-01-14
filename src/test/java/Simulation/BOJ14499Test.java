package Simulation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BOJ14499Test {
	Solving14499 solving14499;

	@BeforeEach
	void init() {
		solving14499 = new Solving14499();
	}

	@Test
	void testSetMap() {
		assertThrows(IllegalArgumentException.class, () -> solving14499.setMap(0, 21));
	}
}