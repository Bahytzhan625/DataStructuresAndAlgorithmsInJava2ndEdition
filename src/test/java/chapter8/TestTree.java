package chapter8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестирование сущности {@link Tree}
 *
 * @author bahytzhan
 * @created 28.10.2021
 * @$Author$
 * @$Revision$
 */
public class TestTree {
	private Tree tree;

	@BeforeAll
	public void init() {
		tree = new Tree();
		tree.insert(50, 15);
		tree.insert(25, 12);
		tree.insert(75, 17);
		tree.insert(12, 15);
		tree.insert(37, 12);
		tree.insert(43, 17);
		tree.insert(30, 15);
		tree.insert(33, 12);
		tree.insert(87, 17);
		tree.insert(93, 15);
		tree.insert(97, 15);
		tree.insert(11, 15);
	}

	/**
	 * Тестирование метода поиска в дереве
	 */
	@Test
	public void testFindMethod() {
		assertEquals(50, tree.find(50).key);
		assertNotEquals(51, tree.find(50).key);
		assertNull(tree.find(	51));
	}

	/**
	 * Тестирование метода вставки в дерево
	 */
	@Test
	public void testInsertMethod() {
		assertNull(tree.find(51));
		tree.insert(51, 51);
		assertNotNull(tree.find(51));
	}

	/**
	 * Тестирование метода для поиска приемника удаляемого узла
	 */
	@Test
	public void checkSuccessorFinder() {
		// поиск приемника для корневого элемента
		Node nodeForDelete = tree.find(50);
		assertEquals(75, tree.getSuccessor(nodeForDelete).key);

		// поиск приемника для узла имеющего правого потомка
		nodeForDelete = tree.find(93);
		assertEquals(97, tree.getSuccessor(nodeForDelete).key);

		// поиск приемника для узла имеющего двух потомков
		nodeForDelete = tree.find(25);
		assertEquals(30, tree.getSuccessor(nodeForDelete).key);

		// поиск приемника для узла не имеющего потомков
		nodeForDelete = tree.find(12);
		assertEquals(12, tree.getSuccessor(nodeForDelete).key);
	}

	/**
	 * Тестирование метода удаления элементов из дерева
	 * с выводом содержимого дерева на каждом этапе, для визуального контроля
	 */
	@Test
	public void testDeleteMethod() {
		System.out.println(tree.displayTree());

		// удаление узла не имеющего потомков
		tree.delete(97);
		assertNull(tree.find(97));
		System.out.println(tree.displayTree());

		// удаление узла имеющего потомков
		tree.delete(30);
		assertNull(tree.find(30));
		System.out.println(tree.displayTree());

		// удаление узла имеющего потомков
		tree.delete(12);
		assertNull(tree.find(12));
		System.out.println(tree.displayTree());

		// удаление ноды имеющей двух потомков
		tree.delete(37);
		assertNull(tree.find(37));
		System.out.println(tree.displayTree());

		// удаление корневого узла
		tree.delete(50);
		assertNull(tree.find(50));
		System.out.println(tree.displayTree());
	}

	@Test
	public void testTraverseMethod() {
		tree.traverse(1);
		tree.traverse(2);
		tree.traverse(3);
	}

	/**
	 * Тестирование метода создающего двоичное дерево из входной строки содержащей буквы, которые должны быть листовыми узлами дерева,
	 * с выводом содержимого дерева на каждом этапе, для визуального контроля
	 */
	@Test
	public void testMakeTreeFromUserCharsMethod() {
		tree = Tree.makeTreeFromUserChars("A");
		System.out.println(tree.displayTree(true));
	}
}
