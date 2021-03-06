package chapter5;

import base.items.LinkItem;
import base.structures.LinkedList;

/**
 * Класс имплементирующий сортированный односвязный список
 *
 * @author bahytzhan
 * @created 09.10.2021
 * @$Author$
 * @$Revision$
 */
public class SortedLinkedList implements LinkedList<LinkItem> {
	private LinkItem first;

	public SortedLinkedList() {
		first = null;
	}

	@Override
	public boolean isEmpty() {
		return (first == null);
	}

	@Override
	public void insert(int key, double data) {
		insert(new Link(key, data));
	}

	@Override
	public void insert(LinkItem item) {
		if (!isEmpty()) {
			if (first.getData() > item.getData()) {
				item.setNext(first);
				first = item;
			} else {
				LinkItem current = first;
				while (current.getNext() != null) {
					if (current.getData() <= item.getData() && current.getNext() > item.getData()) {
						break;
					}
					current = current.getNext();
				}
				item.setNext(current.getNext());
				current.setNext(item);
			}
		} else {
			item.setNext(first);
			first = item;
		}
	}

	@Override
	public LinkItem deleteFirst() {
		if (isEmpty()) {
			throw new UnsupportedOperationException("SortedLinkedList is empty");
		}

		LinkItem temp = first;
		first = first.getNext();
		return temp;
	}

	@Override
	public LinkItem find(LinkItem item) {
		LinkItem current = first;
		while (current.getKey() != item.getKey()) {
			if (current.getNext() == null) {
				return null;
			} else {
				current = current.getNext();
			}
		}

		return current;
	}

	@Override
	public LinkItem delete(LinkItem item) {
		LinkItem current = first;
		LinkItem previous = null;

		if (isEmpty()) {
			return null;
		}

		while (current.getKey() != item.getKey() && current.getKey() < item.getKey()) {
			if (current.getNext() == null) {
				return null;
			} else {
				previous = current;
				current = current.getNext();
			}
		}

		if (previous == null) {
			first = null;
		} else {
			previous.setNext(current.getNext());
		}

		return current;
	}

	@Override
	public LinkItem getFirst() {
		return first;
	}

	@Override
	public void displayList() {
		System.out.println(getDisplayData());
	}

	/**
	 * @return данные для вывода связанного списка на печать
	 */
	public String getDisplayData() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("List (first-->last): ");
		LinkItem current = first;

		if (current == null) {
			return stringBuilder.toString();
		}

		while (current.getNext() != null) {
			stringBuilder.append(current.getDisplayData());

			if (current.getNext() != null) {
				current = current.getNext();
			} else {
				break;
			}
		}
		stringBuilder.append(current.getDisplayData());
		stringBuilder.append("");

		return stringBuilder.toString();
	}
}
