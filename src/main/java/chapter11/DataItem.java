package chapter11;

import base.items.Item;

/**
 * Сущность элемента данных
 *
 * @author bahytzhan
 * @created 22.10.2021
 * @$Author$
 * @$Revision$
 */
public class DataItem implements Item {
	private int key;

	/**
	 * Конструктор
	 *
	 * @param key ключ
	 */
	public DataItem(int key) {
		this.key = key;
	}

	@Override
	public int getKey() {
		return key;
	}

	@Override
	public String getDisplayData() {
		return String.valueOf(key);
	}
}
