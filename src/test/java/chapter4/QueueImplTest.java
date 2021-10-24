package chapter4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author bahytzhan
 * @created 24.10.2021
 * @$Author$
 * @$Revision$
 */
public class QueueImplTest {
	private QueueImpl queue;
	private int collectionSize = 10;

	@BeforeAll
	public void init() {
		queue = new QueueImpl(collectionSize);
	}

	@Test
	public void checkSize() {
		assertEquals(0, queue.size());

		IntStream.range(0, collectionSize).forEach(k -> queue.insert(k));

		assertEquals(collectionSize, queue.size());
	}

	@Test
	public void insertionTest() {
		IntStream.range(0, collectionSize).forEach(k -> queue.insert(k));

		assertEquals(0, queue.peekFront());
	}

	@Test
	public void testingVoidCheck() {
		assertTrue(queue.isEmpty());

		queue.insert(2);
		queue.insert(1);
		queue.remove();
		queue.remove();

		assertTrue(queue.isEmpty());
	}

	@Test
	public void testingFullnessCheck() {
		IntStream.range(0, collectionSize).forEach(k -> queue.insert(k));

		assertTrue(queue.isFull());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testingVoidCheck2() {
		queue.remove();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testingFullnessCheck() {
		IntStream.range(0, collectionSize + 1).forEach(k -> queue.insert(k));
	}
}
