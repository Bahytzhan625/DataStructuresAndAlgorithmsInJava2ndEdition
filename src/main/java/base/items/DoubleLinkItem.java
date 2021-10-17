package base.items;

public interface DoubleLinkItem {
	/**
	 * @return ключ элемента данных
	 */
	int getKey();

	/**
	 * @return данные для печати элемента данных
	 */
	String getDisplayDate();

	/**
	 * @return значение элемента
	 */
	double getData();

	/**
	 * @return ссылка на следующий элемент
	 */
	DoubleLinkItem getNext();

	/**
	 * Установить ссылку на следующий элемент
	 *
	 * @param next элемент
	 */
	void setNext(DoubleLinkItem next);

	/**
	 * @return ссылка на предыдущий элемент
	 */
	DoubleLinkItem getPrevious();

	/**
	 * Установить ссылку на предыдущий элемент
	 *
	 * @param previous элемент
	 */
	void setPrevious(DoubleLinkItem previous);

	/**
	 * Вывести данные о элементе списка на печать
	 */
	void displayLink();
}
