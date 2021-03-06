package chapter10;

import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

/**
 * Перечисление порядков B-дерева
 *
 * @author bahytzhan
 * @created 22.10.2021
 * @$Author$
 * @$Revision$
 */
enum Order {
	TREE_3_ORDER(3),
	TREE_4_ORDER(4),
	TREE_5_ORDER(5),
	TREE_6_ORDER(6),
	TREE_7_ORDER(7),
	TREE_8_ORDER(8),
	TREE_9_ORDER(9),
	TREE_10_ORDER(10);

	private final Integer bOrder;

	static final Map<Integer, Order> map =
			stream(Order.values()).collect(toMap(order -> order.bOrder, order -> order));

	Order(int order) {
		this.bOrder = order;
	}

	public int getOrder() {
		return bOrder;
	}

	/**
	 * Получение порядка B-дерева из цифрового значения
	 *
	 * @param order цифровое значение порядка
	 * @return порядок B-дерева
	 */
	public static Order valueOf(int order) {
		return map.get(order);
	}

	/**
	 * @return следующий за текущим порядком
	 */
	public Order nextOrder() {
		return Order.valueOf(bOrder + 1);
	}
}
