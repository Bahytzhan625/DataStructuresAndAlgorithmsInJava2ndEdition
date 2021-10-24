package chapter12;

/**
 * Сущность узла пирамиды
 *
 * @author bahytzhan
 * @created 24.10.2021
 * @$Author$
 * @$Revision$
 */
public class Node {
	private int key;

	public Node(int key) {
		this.key = key;
	}

	/**
	 * @return ключ
	 */
	public int getKey() {
		return key;
	}

	/**
	 * Установить значение ключа
	 *
	 * @param key ключ
	 */
	public void setKey(int key) {
		this.key = key;
	}
}
