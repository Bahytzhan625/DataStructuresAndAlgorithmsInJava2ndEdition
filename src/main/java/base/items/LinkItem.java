package base.items;

public interface LinkItem {

	/**
	 * @return ключ элемента данных
	 */
	int getKey();

	/**
	 * @return данные для печати элемента данных
	 */
	String getDisplayData();

	/**
	 * @return значение элемента
	 */
	double getData();

	/**
	 * @return ссылка на следующий элемент
	 */
	LinkItem getNext();

	/**
	 * Установить ссылку на следующий элемент
	 *
	 * @param next элемент
	 */
	void setNext(LinkItem next);

	/**
	 * Вывести данные о элементе списка на печать
	 */
	void displayLink();
}
