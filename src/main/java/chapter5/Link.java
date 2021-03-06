package chapter5;

import base.items.LinkItem;

/**
 * Элемент списка
 *
 * @author bahytzhan
 * @created 09.10.2021
 * @$Auhtor$
 * @$Revision$
 */
public class Link implements LinkItem {
	private double data;
	private int key;
	private LinkItem next;

	Link(int key, double data) {
		this.key = key;
		this.data = data;
	}

	@Override
	public int getKey() {
		return key;
	}

	@Override
	public double getData() {
		return data;
	}

	@Override
	public LinkItem getNext() {
		return next;
	}

	@Override
	public void setNext(LinkItem next) {
		this.next = next;
	}

	@Override
	public String getDisplayData() {
		return String.format("{%s, %s}", key, data);
	}

	@Override
	public void displayLink() {
		System.out.println(getDisplayData());
	}
}
