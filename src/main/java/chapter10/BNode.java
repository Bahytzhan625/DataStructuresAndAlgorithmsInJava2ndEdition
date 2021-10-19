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
	 * 
	 */
}
