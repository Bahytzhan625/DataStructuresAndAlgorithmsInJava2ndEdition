package base.structures;

public interface Array {

	/**
	 * Вставка элемента в массив
	 *
	 * @param value вставляемый элемент
	 */
	void insert(long value);

	/**
	 * Вывод содержимого массива
	 */
	void display();

	/**
	 * Сортировка массива
	 */
	void sort();

	/**
	 * Дополнительный метод для тестирования
	 *
	 * Получить содержимое массива
	 *
	 * @return содержимое массива
	 */
	String getValues();
}
