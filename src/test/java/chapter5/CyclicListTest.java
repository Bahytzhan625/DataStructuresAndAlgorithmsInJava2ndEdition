package chapter5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестирование сущности {@link CyclicList}
 *
 * @author bahytzhan
 * @created 26.10.2021
 * @$Author$
 * @$Revision$
 */
public class CyclicListTest {
	private CyclicList cyclicList;

	@BeforeAll
	public void init() {
		cyclicList = new CyclicList();
	}

	@Test
	public void checkIsEmptyMethod() {
		assertTrue(cyclicList.isEmpty());

		cyclicList.insert(1, 1);

		assertFalse(cyclicList.isEmpty());
	}

	@Test
	public void checkInsertFirstMethod() {
		Link link = new Link(1, 1);
		cyclicList.insert(link);
		cyclicList.insert(2, 2);
		cyclicList.insert(3, 3);

		assertEquals(link, cyclicList.getFirst());
	}

	@Test
	public void checkDeleteFirstMethod() {
		Link link = new Link(1, 1);
		Link link2 = new Link(3, 3);

		cyclicList.insert(link);
		cyclicList.insert(2, 2);
		cyclicList.insert(link2);

		assertEquals(link2, cyclicList.deleteFirst());
		assertEquals(link, cyclicList.getFirst());
	}

	@Test
	public void checkFindMethod() {
		Link link = new Link(1, 1);
		Link link2 = new Link(3, 3);

		cyclicList.insert(link);
		cyclicList.insert(2, 2);
		cyclicList.insert(link2);

		assertEquals(link, cyclicList.find(link));
		assertEquals(link2, cyclicList.find(link2));
	}

	@Test
	public void checkDeleteMethod() {
		Link link = new Link(1, 1);

		cyclicList.insert(link);
		cyclicList.insert(2, 2);
		cyclicList.insert(3, 3);

		assertEquals(link, cyclicList.find(link));
		cyclicList.delete(link);
		assertNull(cyclicList.find(link));
	}
}
