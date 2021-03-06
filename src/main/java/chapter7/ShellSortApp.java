package chapter7;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author bahytzhan
 * @created 17.10.2021
 * @$Author$
 * @$Revision$
 */
public class ShellSortApp {
	public static void main(String[] args) {
		int maxSize = 15;
		ArraySh arraySh;
		arraySh = new ArraySh(maxSize);

		Random random = new Random();
		IntStream.range(0, maxSize).forEach(k -> arraySh.insert(random.nextInt(maxSize * 10)));

		System.out.println(arraySh.display());
		arraySh.shellSort(true);
		System.out.println("Result");
		System.out.println(arraySh.display());
	}
}
