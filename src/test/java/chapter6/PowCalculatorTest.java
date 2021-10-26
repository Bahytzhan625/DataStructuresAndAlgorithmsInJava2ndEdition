package chapter6;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тестирование сущности {@Link PowCalculator}
 *
 * @author bahytzhan
 * @created 26.10.2021
 * @$Author$
 * @$Revision$
 */
public class PowCalculatorTest {
	/** Тестирование метода рекурсивного возведения в степень */
	@Test
	public void testPowMethod() {
		IntStream.range(1, 10).forEach(k -> assertTrue(Math.pow(2, k) == PowCalculator.pow(2, k)));
	}
}
