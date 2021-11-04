package chapter12;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тестирование сущности {@link PriorityQ}
 *
 * @author bahytzhan
 * @created 04.11.2021
 * @$Author$
 * @$Revision$
 */
public class TestPriorityQ {
	private PriorityQ priorityQ;
	private int priorityQSize = 50;

	@BeforeAll
	public void init() {
		priorityQ = new PriorityQ(100);
		IntStream.range(priorityQSize / 2, priorityQSize).forEach((key) -> priorityQ.insert((int) (java.lang.Math.random() * key)));
	}

	/**
	 * Тестирование метода вставки в приоритетную очередь
	 */
	@Test
	public void testInsertMethod() {
		IntStream.range(priorityQSize / 2, priorityQSize).forEach((key) -> priorityQ.insert((int) (java.lang.Math.random() * key)));
	}

	/**
	 * Тестирование метода удаления из приоритетной очереди
	 */
	@Test
	public void testRemoveReverseOrder() {
		IntStream.range(0, (priorityQSize / 2) / 2).forEach((key) -> {
			int previousValue = priorityQ.remove();
			int tempValue = priorityQ.remove();
			assertTrue(previousValue >= tempValue);
		});
	}
}
