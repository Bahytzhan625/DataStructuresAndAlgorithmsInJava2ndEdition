package chapter5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестирование сущности {@link PriorityQueueOnSortedLinkedList}
 *
 * @author bahytzhan
 * @created 26.10.2021
 * @$Author$
 * @$Revision$
 */
public class PriorityQueueOnSortedLinkedListTest {
	private PriorityQueueOnSortedLinkedList priorityQueue;

	@BeforeAll
	public void init() {
		priorityQueue = new PriorityQueueOnSortedLinkedList();
	}

	@Test
	public void testingVoidCheck() {
		assertTrue(priorityQueue.isEmpty());

		priorityQueue.insert(1);
		priorityQueue.insert(2);
		priorityQueue.remove();
		priorityQueue.remove();

		assertTrue(priorityQueue.isEmpty());
	}

	@Test
	public void testingFullnessCheck() {
		assertFalse(priorityQueue.isFull());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testingVoidCheck2() {
		priorityQueue.remove();
	}

	@Test
	public void checkPriority() {
		priorityQueue.insert(100);
		priorityQueue.insert(20);
		priorityQueue.insert(30);
		priorityQueue.insert(11);
		priorityQueue.insert(2);

		assertEquals(2, priorityQueue.remove());
		assertEquals(11, priorityQueue.remove());
		assertEquals(20, priorityQueue.remove());
		assertEquals(30, priorityQueue.remove());
		assertEquals(100, priorityQueue.remove());
	}

	@Test
	public void checkPriorityPeek() {
		priorityQueue.insert(50);
		priorityQueue.insert(20);
		priorityQueue.insert(1);
		priorityQueue.insert(30);
		priorityQueue.insert(11);

		assertEquals(1, priorityQueue.peekFront());
	}
}
