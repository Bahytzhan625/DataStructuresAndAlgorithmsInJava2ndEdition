package chapter10;

import base.items.Item;

/**
 * Узел B-дерева
 *
 * @author bahytzhan
 * @created 18.10.2021
 * @$Author$
 * @$Revision$
 */
class BNode {
	private final int order;
	private int numItems;
	private BNode parent;
	private Item[] itemArray;
	private BNode[] childArray;

	/**
	 * ctor
	 *
	 * @param order порядок B-дерева
	 */
	BNode(Order order) {
		this.order = order.getOrder();
		itemArray = new Item[this.order - 1];
		childArray = new BNode[this.order];
	}

	/**
	 * ctor
	 *
	 * @param order порядок B-дерева
	 * @param item  элемент данных
	 */
	BNode(Order order, Item item) {
		this(order);
		this.insertItem(item);
	}

	/**
	 * @return родительский узел
	 */
	BNode getParent() {
		return parent;
	}

	/**
	 * Получить элемент данных
	 *
	 * @param index индекс элемента данных
	 * @return элемент данных
	 */
	Item getItem(int index) {
		if ((index < 0) || (index >= itemArray.length)) {
			return null;
		} else {
			return itemArray[index];
		}
	}

	/**
	 * Связать узел с потомком
	 *
	 * @param childNum позиция потомка
	 * @param child узел потомок
	 */
	void connectChild(int childNum, BNode child) {
		childArray[childNum] = child;
		if (child != null) {
			child.parent = this;
		}
	}

	/**
	 * Отсоединить потомка от узла
	 *
	 * @param childNum позиция потомка
	 * @return отсоединенный потомок
	 */
	BNode disconnectChild(int childNum) {
		BNode tempNode = childArray[childNum];
		childArray[childNum] = null;
		return tempNode;
	}

	/**
	 * Получить узел потомок
	 *
	 * @param childNum номер узла
	 * @return узел потомок
	 */
	BNode getChild(int childNum) {
		return childArray[childNum];
	}

	/**
	 * @return признак листового узла
	 */
	boolean isLeaf() {
		return childArray[0] == null;
	}

	/**
	 * @return количество элементов данных
	 */
	int getNumItems() {
		return numItems;
	}

	/**
	 * @return признак заполнености узла
	 */
	boolean isFull() {
		return numItems == order - 1;
	}

	/**
	 * Определить индекс элемента в пределах узла
	 *
	 * @param key ключ элемента
	 * @return индекс элемента
	 */
	int findItem(long key) {
		for (int i = 0; i < order - 1; i++) {
			if (itemArray[i] == null) {
				break;
			} else if ((long)itemArray[i].getKey() == key) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Вставить элемент данных
	 * предполагается, что узел не пуст
	 *
	 * @param newItem элемент данных
	 * @return индекс вставляемого элемента данных
	 */
	int insertItem(Item newItem) {
		numItems++;
		long newKey = (long)newItem.getKey();
		for (int i = order - 2; i >= 0; i--) {
			if (itemArray[i] != null) {
				long itsKey = (long)itemArray[i].getKey();
				if (newKey < itsKey) {
					itemArray[i + 1] = itemArray[i];
				} else {
					itemArray[i + 1] = newItem;
					return i + 1;
				}
			}
		}
		itemArray[0] = newItem;
		return 0;
	}

	/**
	 * Выполнить очистку узла от элемента данных
	 */
	void clean() {
		while (numItems != 0) {
			removeItem();
		}
	}

	/**
	 * Удалить наибольший элемент данных
	 * предполагается, что узел не пуст
	 *
	 * @return удаленный элемент данных
	 */
	Item removeItem() {
		if (numItems == 0) {
			return null;
		}

		Item temp = itemArray[numItems - 1];
		itemArray[numItems - 1] = null;
		numItems--;
		return temp;
	}

	/**
	 * @return данных для печати узла
	 */
	String getDisplayData() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < numItems; i++) {
			builder.append(itemArray[i].getDisplayData());
		}
		builder.append("/");

		return builder.toString();
	}
}
