package chapter10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static chapter10.Order.TREE_3_ORDER;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестирование сущности {@link BNode} для B-дерева 3 порядка
 *
 * @author bahytzhan
 * @created 31.10.2021
 * @$Author$
 * @$Revision$
 */
public class TestNode3Order {
	private static final Order bTreeOrder = TREE_3_ORDER;

	private static final DataItem leftDataItem = new DataItem(5);
	private static final DataItem rightDataItem = new DataItem(10);

	private static final BNode firstChildNode = new BNode(bTreeOrder);
	private static final BNode secondChildNode = new BNode(bTreeOrder);
	private static final BNode thirdChildNode = new BNode(bTreeOrder);

	private BNode bNode;

	@BeforeAll
	public void init() {
		bNode = new BNode(bTreeOrder);
		bNode.insertItem(leftDataItem);
		bNode.insertItem(rightDataItem);
	}

	/**
	 * Тестирование метода удаления элемента данных
	 */
	@Test
	public void testDeleteItem() {
		assertEquals(rightDataItem, bNode.removeItem());
		assertEquals(leftDataItem, bNode.removeItem());
		assertNull(bNode.removeItem());
	}

	/**
	 * Тестирование метода вставки элемента данных
	 */
	@Test
	public void testInsertItems() {
		bNode = new BNode(bTreeOrder);

		assertTrue(bNode.insertItem(new DataItem(2)) == 0);
		assertTrue(bNode.insertItem(new DataItem(1)) == 0);
	}

	/**
	 * Тестирование метода вставки элемента данных
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testFailInsertItems() {
		bNode = new BNode(bTreeOrder);

		assertTrue(bNode.insertItem(new DataItem(1)) == 0);
		assertTrue(bNode.insertItem(new DataItem(2)) == 1);
		assertTrue(bNode.insertItem(new DataItem(3)) == 2);
	}

	/**
	 * Тестирование метода поиска индекса элемента данных
	 */
	@Test
	public void testFindItemMethod() {
		assertTrue(bNode.findItem(leftDataItem.getKey()) == 0);
		assertTrue(bNode.findItem(rightDataItem.getKey()) == 1);
		assertTrue(bNode.findItem(100) == -1);
	}

	/**
	 * Тестирование метода, проверяющего заполненность узла
	 */
	@Test
	public void testIsFullMethod() {
		assertTrue(bNode.isFull());
		bNode.removeItem();
		assertFalse(bNode.isFull());
		bNode.insertItem(rightDataItem);
		assertTrue(bNode.isFull());
	}

	/**
	 * Тестирование метода возвращающего количество элементов данных в узле
	 */
	@Test
	public void testGettingNumElements() {
		assertTrue(bNode.getNumItems() == 2);
		bNode.removeItem();
		assertTrue(bNode.getNumItems() == 1);
		bNode.removeItem();
		assertTrue(bNode.getNumItems() == 0);
		bNode.insertItem(leftDataItem);
		assertTrue(bNode.getNumItems() == 1);
		bNode.insertItem(rightDataItem);
		assertTrue(bNode.getNumItems() == 2);
	}

	/**
	 * Тестирование метода получения данных для печати
	 */
	@Test
	public void testGetDisplayData() {
		assertEquals(bNode.getDisplayData(), String.format("/%s/%s/", leftDataItem.getKey(), rightDataItem.getKey()));
		bNode.removeItem();
		assertEquals(bNode.getDisplayData(), String.format("/%s/", leftDataItem.getKey()));
		bNode.removeItem();
		assertEquals("/", bNode.getDisplayData());
		bNode.insertItem(leftDataItem);
		assertEquals(bNode.getDisplayData(), String.format("/%s/", leftDataItem.getKey()));
		bNode.insertItem(rightDataItem);
		assertEquals(bNode.getDisplayData(), String.format("/%s/%s/", leftDataItem.getKey(), rightDataItem.getKey()));
	}

	/**
	 * Тестирование метода получения элемента данных по индексу
	 */
	@Test
	public void testGettingItem() {
		assertEquals(leftDataItem, bNode.getItem(BTreeOrder3Constants.LEFT_ITEM));
		assertEquals(rightDataItem, bNode.getItem(BTreeOrder3Constants.CENTRAL_ITEM));
		assertNull(bNode.getItem(-1));
		assertNull(bNode.getItem(-1));
	}

	/**
	 * Тестирование метода связки узла с потомком
	 */
	@Test
	public void testConnectingAndGettingChild() {
		bNode.connectChild(BTreeOrder3Constants.LEFT_CHILD, firstChildNode);
		bNode.connectChild(BTreeOrder3Constants.CENTRAL_CHILD, secondChildNode);
		bNode.connectChild(BTreeOrder3Constants.RIGHT_CHILD, thirdChildNode);

		assertEquals(firstChildNode, bNode.getChild(BTreeOrder3Constants.LEFT_CHILD));
		assertEquals(secondChildNode, bNode.getChild(BTreeOrder3Constants.CENTRAL_CHILD));
		assertEquals(thirdChildNode, bNode.getChild(BTreeOrder3Constants.RIGHT_CHILD));
	}

	/**
	 * Тестирование метода отсоединения потомка от узла
	 */
	@Test
	public void testDisconnectingChild() {
		bNode.connectChild(BTreeOrder3Constants.LEFT_CHILD, firstChildNode);
		bNode.connectChild(BTreeOrder3Constants.CENTRAL_CHILD, secondChildNode);
		bNode.connectChild(BTreeOrder3Constants.RIGHT_CHILD, thirdChildNode);

		assertEquals(firstChildNode, bNode.disconnectChild(BTreeOrder3Constants.LEFT_CHILD));
		assertNull(bNode.getChild(BTreeOrder3Constants.LEFT_CHILD));
		assertEquals(secondChildNode, bNode.disconnectChild(BTreeOrder3Constants.CENTRAL_CHILD));
		assertNull(bNode.getChild(BTreeOrder3Constants.CENTRAL_CHILD));
		assertEquals(thirdChildNode, bNode.disconnectChild(BTreeOrder3Constants.RIGHT_CHILD));
		assertNull(bNode.getChild(BTreeOrder3Constants.RIGHT_CHILD));

		assertNull(bNode.disconnectChild(BTreeOrder3Constants.LEFT_CHILD));
		assertNull(bNode.disconnectChild(BTreeOrder3Constants.CENTRAL_CHILD));
		assertNull(bNode.disconnectChild(BTreeOrder3Constants.RIGHT_CHILD));
	}

	/**
	 * Тестирование метода возвращающего признак листового узла
	 */
	@Test
	public void checkIsLeafMethod() {
		assertTrue(bNode.isLeaf());
		bNode.connectChild(BTreeOrder3Constants.LEFT_CHILD, firstChildNode);
		assertFalse(bNode.isLeaf());
		bNode.connectChild(BTreeOrder3Constants.LEFT_CHILD, secondChildNode);
		assertFalse(bNode.isLeaf());
		bNode.disconnectChild(BTreeOrder3Constants.CENTRAL_CHILD);
		assertFalse(bNode.isLeaf());
		bNode.disconnectChild(BTreeOrder3Constants.LEFT_CHILD);
		assertTrue(bNode.isLeaf());
	}

	/**
	 * Тестирование метода получения родительского узла
	 */
	@Test
	public void checkGettingParent() {
		bNode.connectChild(BTreeOrder3Constants.LEFT_CHILD, firstChildNode);
		bNode.connectChild(BTreeOrder3Constants.CENTRAL_CHILD, secondChildNode);
		bNode.connectChild(BTreeOrder3Constants.RIGHT_CHILD, thirdChildNode);

		assertEquals(bNode, firstChildNode.getParent());
		assertEquals(bNode, secondChildNode.getParent());
		assertEquals(bNode, thirdChildNode.getParent());
	}
}
