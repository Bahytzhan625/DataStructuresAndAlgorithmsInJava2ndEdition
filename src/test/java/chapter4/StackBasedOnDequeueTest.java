package chapter4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author bahytzhan
 * @created 25.10.2021
 * @$Author$
 * @$Revision$
 */
public class StackBasedOnDequeueTest {
	private StackBasedOnDequeue stackBasedOnDequeue;
	private int collectionSize = 10;

	@BeforeAll
	public void init() {
		stackBasedOnDequeue = new StackBasedOnDequeue(collectionSize);
	}

	@Test
	public void insertionTest() {
		IntStream.range(0, collectionSize).forEach(k -> stackBasedOnDequeue.insert(k));

		assertEquals(9, stackBasedOnDequeue.remove());
		assertEquals(8, stackBasedOnDequeue.remove());
	}

	@Test
	public void testPeek() {
		IntStream.range(0, collectionSize).forEach(k -> stackBasedOnDequeue.insert(k));

		assertEquals(9, stackBasedOnDequeue.peekFront());
		assertEquals(9, stackBasedOnDequeue.peekFront());
	}

	@Test
	public void testingVoidCheck() {
		assertTrue(stackBasedOnDequeue.isEmpty());

		stackBasedOnDequeue.insert(3);
		stackBasedOnDequeue.insert(1);
		stackBasedOnDequeue.remove();
		stackBasedOnDequeue.remove();

		assertTrue(stackBasedOnDequeue.isEmpty());
	}

	@Test
	public void testingFullnessCheck() {
		IntStream.range(0, collectionSize).forEach(k -> stackBasedOnDequeue.insert(k));

		assertTrue(stackBasedOnDequeue.isFull());
	}


}
