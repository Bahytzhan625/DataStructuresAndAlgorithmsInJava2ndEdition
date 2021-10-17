package base.structures;

public interface Queue {

	/**
	 * Вставка элемента в очередь
	 *
	 * @param value вставляемый элемент
	 * @throws UnsupportedOperationException исключение в случае если дальнейшее добавление элементов невозможно по причине заполненности очереди
	 */
	void insert(long value) throws UnsupportedOperationException;

	/**
	 * Удаление элемента из очереди
	 *
	 * @return удаленный элемент
	 */
	long remove();

	/**
	 * Получение первого элемента в очереди
	 *
	 * @return первый элемент в очереди
	 */
	long peekFront();

	/**
	 * Проверить пустоту коллекции
	 *
	 * @return признак отсутствия элементов в коллекции
	 */
	boolean isEmpty();

	/**
	 * Проверить заполненость коллекции
	 *
	 * @return признак заполненности коллекции
	 */
	boolean isFull();
}
