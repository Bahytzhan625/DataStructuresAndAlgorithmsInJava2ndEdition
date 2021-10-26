package chapter5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тестирование сущности {@link StackOnCyclicList}
 *
 * @author bahytzhan
 * @created 26.10.2021
 * @$Author$
 * @$Revision$
 */
public class StackOnCyclicListTest {
	private StackOnCyclicList stackOnCyclicList;
	private int collectionSize = 10;

	@BeforeAll
	public void init() {
		stackOnCyclicList = new StackOnCyclicList();
	}

	@Test
	public void insertionTest() {
		IntStream.range(0, collectionSize).forEach(k -> stackOnCyclicList.insert(k));

		assertEquals(9, stackOnCyclicList.remove());
		assertEquals(8, stackOnCyclicList.remove());
	}

	@Test
	public void testPeek() {
		IntStream.range(0, collectionSize).forEach(k -> stackOnCyclicList.insert(k));

		assertEquals(0, stackOnCyclicList.peekFront());
		assertEquals(0, stackOnCyclicList.peekFront());
	}

	@Test
	public void testingVoidCheck() {
		assertTrue(stackOnCyclicList.isEmpty());

		stackOnCyclicList.insert(3);
		stackOnCyclicList.insert(1);
		stackOnCyclicList.remove();
		stackOnCyclicList.remove();

		assertTrue(stackOnCyclicList.isEmpty());
	}

	@Test
	public void testingFullnessCheck() {
		assertFalse(stackOnCyclicList.isFull());
	}
}
