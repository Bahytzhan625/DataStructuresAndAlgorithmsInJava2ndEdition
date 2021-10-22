package chapter10;

import base.items.Item;

/**
 * Элемент данных для B-дерева
 *
 * @author bahytzhan
 * @created 22.10.2021
 * @$Author$
 * @$Revision$
 */
class DataItem implements Item {
	private long key;

	DataItem(long key) {
		this.key = key;
	}

	/**
	 * @return значение элемента данных
	 */
	public int getKey() {
		return (int)key;
	}

	/**
	 * @return данные для печати элемента данных
	 */
	public String getDisplayData() {
		return String.format("/%s", key);
	}
}
