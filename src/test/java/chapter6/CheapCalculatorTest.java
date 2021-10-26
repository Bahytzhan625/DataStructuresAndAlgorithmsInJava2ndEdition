package chapter6;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тестирование сущности {@link CheapCalculatorTest}
 *
 * @author bahytzhan
 * @created 26.10.2021
 * @$Author$
 * @$Revision$
 */
public class CheapCalculatorTest {
	/** Тестирование метода рекурсивного умножения двух множителей */
	@Test
	public void checkMultiplicationMethod() {
		IntStream.range(1, 10).forEach(k -> assertEquals(k * k, CheapCalculator.multiplication(k, k)));
	}
}
