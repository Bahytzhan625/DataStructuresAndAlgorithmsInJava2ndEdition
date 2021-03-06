package base.structures;

public interface LinkedList<T> {

	/**
	 * Проверить пустоту коллекции
	 *
	 * @return признак отсутствия элементов в коллекции
	 */
	boolean isEmpty();

	/**
	 * Вставка элемента в список
	 *
	 * @param key ключ
	 * @param data значение
	 */
	void insert(int key, double data);

	/**
	 * Вставка элемента в список
	 *
	 * @param item вставляемый элемент
	 */
	void insert(T item);

	/**
	 * Удаление первого элемента в списке
	 *
	 * @return удаленный элемент
	 */
	T deleteFirst();

	/**
	 * Поиск элемента в списке
	 *
	 * @param item элемент данных для поиска
	 * @return найденный элемент
	 */
	T find(T item);

	/**
	 * Удаление элемента с ключом key из списка
	 *
	 * @param item элемент данных для поиска
	 * @return найденный элемент
	 */
	T delete(T item);

	/**
	 * Получение первого элемента в списке
	 *
	 * @return первый элемент
	 */
	T getFirst();

	/**
	 * Вывод содержимого массива
	 */
	void displayList();
}
