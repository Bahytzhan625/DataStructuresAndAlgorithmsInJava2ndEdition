package chapter10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тестирование сущности {@link DataItem}
 *
 * @author bahytzhan
 * @created 31.10.2021
 * @$Author$
 * @$Revision$
 */
public class TestDataItem {
	/**
	 * Тестирование метода получения данных для печати
	 */
	@Test
	public void testGetDisplayData() {
		DataItem dataItem = new DataItem(1L);

		assertEquals(dataItem.getDisplayData(), String.format("/%s", dataItem.getKey()));

		dataItem = new DataItem(10L);

		assertEquals(dataItem.getDisplayData(), String.format("/%s", dataItem.getKey()));
	}
}
