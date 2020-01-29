package Realization;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeTest {
	@Test
	void testMinus() {
		Time time = new Time(10, 10);
		assertEquals("9 25", time.minus(45));
		time = new Time(0, 0);
		assertEquals("23 15", time.minus(45));
	}
}