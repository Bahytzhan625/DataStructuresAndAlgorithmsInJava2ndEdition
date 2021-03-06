package base.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public interface Util {

	/**
	 * Получить полученную строку из потока ввода
	 *
	 * @param inputStream поток ввода
	 * @return строка ввода
	 * @throws IOException в случае ошибок при получении строки
	 */
	static String getString(InputStream inputStream) throws IOException {

		InputStreamReader isr = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(isr);
		return br.readLine();
	}

	/**
	 * Получить символ из потока ввода
	 *
	 * @param inputStream поток ввода
	 * @return введенный символ
	 * @throws IOException в случае ошибок при получении символа
	 */
	static char getChar(InputStream inputStream) throws IOException {

		return getString(inputStream).charAt(0);
	}

	/**
	 * Получить число из потока ввода
	 *
	 * @param inputStream поток ввода
	 * @return введенное число
	 * @throws IOException в случае ошибок при получении числа
	 */
	static int getInt(InputStream inputStream) throws IOException {

		return Integer.parseInt(getString(inputStream));
	}
}
