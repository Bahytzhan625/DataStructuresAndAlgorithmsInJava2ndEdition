package chapter8;

/**
 * Класс представляющий узел дерева
 *
 * @author bahytzhan
 * @created 17.10.2021
 * @$Author$
 * @$Revision$
 */
public class Node {
	public int key;
	public int value;
	Node leftChild;
	Node rightChild;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}

	void displayNode() {
		System.out.println(String.format("{%s,%s}", key, value));
	}
}
