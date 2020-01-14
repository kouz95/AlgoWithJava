package Simulation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BOJ14499Test {
	BOJ14499 boj14499;

	@BeforeEach
	void init() {
		boj14499 = new BOJ14499();
	}

	@Test
	void testSetMap() {
		assertThrows(IllegalArgumentException.class, () -> boj14499.setMap(0, 21));
	}
}