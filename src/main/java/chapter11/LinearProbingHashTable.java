package chapter11;

import base.items.Item;
import base.structures.HashTable;

/**
 * Сущность хэш-таблицы с линейным пробированием
 *
 * @author bahytzhan
 * @created 23.10.2021
 * @$Author$
 * @$Revision$
 */
public class LinearProbingHashTable implements HashTable<Item> {
	protected Item[] hashArray;
	protected int arraySize;
	protected Item deletedItem;
	private int elementsNumber;

	/**
	 * Конструктор для классов наследников
	 */
	protected LinearProbingHashTable() {}

	/**
	 * Конструктор
	 *
	 * @param size размер хэш-таблицы
	 */
	public LinearProbingHashTable(int size) {
		arraySize = size;
		hashArray = new DataItem[arraySize];
		deletedItem = new DataItem(-1);
		elementsNumber = 0;
	}

	@Override
	public int getHashTableSize() {
		return arraySize;
	}

	@Override
	public int getElementsNumber() {
		return elementsNumber;
	}

	@Override
	public int hashFunction(Item item) {
		return item.getKey() % arraySize;
	}

	@Override
	public void insert(Item item) {
		if (getLoadFactor() > MAX_LOAD_FACTOR) {
			rehash();
		}

		int hashValue = hashFunction(item);

		while (hashArray[hashValue] != null && hashArray[hashValue].getKey() != -1) {
			++hashValue;
			hashValue %= arraySize;
		}

		hashArray[hashValue] = item;
		elementsNumber++;
	}

	@Override
	public Item delete(Item item) {
		int hashValue = hashFunction(item);

		while (hashArray[hashValue] != null) {
			if (hashArray[hashValue].getKey() == item.getKey()) {
				Item dataItem = hashArray[hashValue];
				hashArray[hashValue] = deletedItem;
				elementsNumber--;
				return dataItem;
			}
			++hashValue;
			hashValue %= arraySize;
		}
		return null;
	}

	@Override
	public Item find(Item item) {
		int hashValue = hashFunction(item);

		while (hashArray[hashValue] != null) {
			if (hashArray[hashValue].getKey() == item.getKey()) {
				return hashArray[hashValue];
			}
			++hashValue;
			hashValue %= arraySize;
		}
		return null;
	}

	@Override
	public void rehash() {
		arraySize = HashTable.getPrime(arraySize * 2);
		elementsNumber = 0;
		Item[] tempArray = hashArray.clone();
		hashArray = new Item[arraySize];

		for (int i = 0; i < tempArray.length; i++) {
			if (tempArray[i] != null && tempArray[i].getKey() != deletedItem.getKey()) {
				insert(tempArray[i]);
			}
		}
	}

	@Override
	public Item[] getHashArray() {
		return hashArray.clone();
	}

	@Override
	public String getDisplayData() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(this.getClass().getSimpleName());
		stringBuilder.append(String.format("%nHash table size: %s", getHashTableSize()));
		stringBuilder.append(String.format("%nElements number: %s", getElementsNumber()));
		stringBuilder.append(String.format("%nLoad factor: %s", getLoadFactor()));
		stringBuilder.append("\n");

		for (int i = 0; i < arraySize; i++) {
			if (hashArray[i] != null) {
				stringBuilder.append(String.format("%s ", hashArray[i].getKey()));
			} else {
				stringBuilder.append("** ");
			}
		}
		stringBuilder.append("");

		return stringBuilder.toString();
	}
}
