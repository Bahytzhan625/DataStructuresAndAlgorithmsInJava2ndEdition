package chapter5;

import base.structures.Queue;

/**
 * Программный проект 5.4 - Program project 5.4
 * Класс имплементирующий стэк основанный на цикличном списке
 *
 * @author bahytzhan
 * @created 10.10.2021
 * @$Author$
 * @$Revision$
 */
class StackOnCyclicList implements Queue {
	private CyclicList cyclicList;
	private int counter = 0;

	StackOnCyclicList() {
		cyclicList = new CyclicList();
	}

	@Override
	public void insert(long value) {
		cyclicList.insert(counter++, value);
	}

	@Override
	public long remove() {
		return (long) cyclicList.deleteFirst().getData();
	}

	@Override
	public long peekFront() {
		return (long) cyclicList.getFirst().getData();
	}

	@Override
	public boolean isEmpty() {
		return cyclicList.isEmpty();
	}

	@Override
	public boolean isFull() {
		return false;
	}
}
