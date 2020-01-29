package Realization;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BOJ2884Test {
	BOJ2884 boj2884;

	@BeforeEach
	void init() {
		boj2884 = new BOJ2884();
	}

	@Test
	void testInputTime() {
		assertEquals(10, BOJ2884.getHours("10 10"));
		assertEquals(12, BOJ2884.getMinutes("9 12"));
	}
}