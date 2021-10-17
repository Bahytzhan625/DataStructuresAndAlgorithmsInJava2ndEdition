package base.items;

public interface Item {

	/**
	 * @return ключ элемента данных
	 */
	int getKey();

	/**
	 * @return данные для печати элемента данных
	 */
	String getDisplayData();
}
