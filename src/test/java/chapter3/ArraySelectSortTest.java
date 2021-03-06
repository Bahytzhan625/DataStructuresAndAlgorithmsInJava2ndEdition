package chapter3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author bahytzhan
 * @created 24.10.2021
 * @$Author$
 * @$Revision$
 */
public class ArraySelectSortTest {
	private int arraySize = 10;
	private ArraySelectSort arraySelectSort;

	@BeforeAll
	public void init() {
		arraySelectSort = new ArraySelectSort(arraySize);
	}

	@Test
	public void insertionTesting() {
		arraySelectSort.insert(2);
		arraySelectSort.insert(1);
		arraySelectSort.insert(3);

		assertEquals("2, 1, 3", arraySelectSort.getValues());
	}

	@Test
	public void testSortBySelectMethod() {
		arraySelectSort.insert(3);
		arraySelectSort.insert(1);
		arraySelectSort.insert(5);
		arraySelectSort.insert(6);
		arraySelectSort.insert(2);
		arraySelectSort.insert(0);
		arraySelectSort.insert(8);
		arraySelectSort.insert(9);
		arraySelectSort.insert(4);
		arraySelectSort.insert(7);

		arraySelectSort.sort();

		assertEquals("0, 1, 2, 3, 4, 5, 6, 7, 8, 9", arraySelectSort.getValues());
	}
}
