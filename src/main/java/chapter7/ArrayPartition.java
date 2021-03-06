package chapter7;

/**
 * Класс демонстрирующий разбиения в массив
 *
 * @author bahytzhan
 * @created 12.10.2021
 * @$Author$
 * @$Revision$
 */
class ArrayPartition {
	private long[] theArray;
	private int nElements;

	ArrayPartition(int maxSize) {
		theArray = new long[maxSize];
		nElements = 0;
	}

	/**
	 * Вставка элемента в массив
	 *
	 * @param value вставляемое значение
	 * @throws IndexOutOfBoundsException в случае превышения максимально возможного количества элементов
	 */
	public void insert(long value) throws IndexOutOfBoundsException {
		theArray[nElements++] = value;
	}

	/**
	 * Получение размера массива
	 *
	 * @return размер массива
	 */
	public int size() {
		return nElements;
	}

	/**
	 * Вывод содержимого массива
	 *
	 * @return содержимое
	 */
	public String display() {
		StringBuilder builder = new StringBuilder();

		builder.append("A = ");
		for (int i = 0; i < nElements; i++) {
			builder.append(theArray[i]);
			builder.append(" ");
		}

		return builder.toString();
	}

	/**
	 * Программный проект 7.1 - Program project 7.1
	 * Разбиение массива
	 *
	 * @param left левая граница массива
	 * @param right правая граница массива
	 * @return опорный элемент
	 */
	int partitionItWithMaxElement(int left, int right) {
		int leftPartition = left - 1;
		int rightPartition = right + 1;

		while (true) {
			// поиск большего элемента
			while (leftPartition < right && theArray[++leftPartition] < theArray[nElements - 1]) {

			}

			// поиск меньшего элемента
			while (rightPartition > left && theArray[--rightPartition] > theArray[nElements -1]) {

			}

			// Указатели сошлись, разбиение закончено
			if (leftPartition >= rightPartition) {
				break;
			} else {
				swap(leftPartition, rightPartition);
			}
		}

		return leftPartition;
	}

	/**
	 * Разбиение массива
	 *
	 * @param left левая граница массива
	 * @param right правая граница массива
	 * @param median медиана
	 * @return опорный элемент
	 */
	int partitionIt(int left, int right, long median) {
		int leftPartition = left - 1;
		int rightPartition = right + 1;

		while (true) {
			// поиск большего элемента
			while (leftPartition < right && theArray[++leftPartition] < median) {

			}

			// поиск меньшего элемента
			while (rightPartition > left && theArray[--rightPartition] > median) {

			}

			// Указатели сошлись, разбиение закончено
			if (leftPartition >= rightPartition) {
				break;
			} else {
				swap(leftPartition, rightPartition);
			}
		}

		return leftPartition;
	}

	/**
	 * Программный проект 7.3 - Program project 7.3
	 * Поиск медианы массива путем рекурсивного разбиения
	 *
	 * @param left левая граница массива
	 * @param right правая граница массива
	 * @return опорный элемент
	 */
	int medianReq(int left, int right) {
		int leftPartition = left - 1;
		int rightPartition = right - 1;

		while (true) {
			// поиск большего элемента
			while (leftPartition < right && theArray[++leftPartition] < theArray[nElements - 1]) {

			}

			// поиск меньшего элемента
			while (rightPartition > left && theArray[--rightPartition] > theArray[nElements -1]) {

			}

			// Указатели сошлись, разбиение закончено
			if (leftPartition >= rightPartition) {
				break;
			}
		}

		return leftPartition;
	}

	/**
	 * Перестановка двух элементов
	 *
	 * @param firstValue первый переставляемый элемент
	 * @param secondValue второй переставляемый элемент
	 */
	void swap(int firstValue, int secondValue) {
		theArray[firstValue] = theArray[firstValue] + theArray[secondValue];
		theArray[secondValue] = theArray[firstValue] - theArray[secondValue];
		theArray[firstValue] = theArray[firstValue] - theArray[secondValue];
	}
}
