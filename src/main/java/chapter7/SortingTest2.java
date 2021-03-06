package chapter7;

import java.util.Calendar;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Упражнение 7.3 - Exercise 7.3
 *
 * Класс сравнивающий быстродействие сортировки Шелла и Быстрой сортировки
 *
 * @author bahytzhan
 * @created 17.10.2021
 * @$Author$
 * @$Revision$
 */
public class SortingTest2 {
	public static void main(String[] args) {
		int maxSize = 1_000_000;
		Random random = new Random(maxSize * 10);

		ArraySh arraySh = new ArraySh(maxSize);
		ArrayQk arrayQk = new ArrayQk(maxSize);

		IntStream.range(0, maxSize).forEach(k -> {
			long randomValue = random.nextInt(maxSize * 10);
			arraySh.insert(randomValue);
			arrayQk.insert(randomValue);
		});

		Long startTime = Calendar.getInstance().getTime().getTime();

		System.out.println(String.format("start shell sorting of %s elements", maxSize));
		arraySh.shellSort(false);
		System.out.println(String.format("shell sorting took %s", Calendar.getInstance().getTime().getTime() - startTime));

		startTime = Calendar.getInstance().getTime().getTime();

		System.out.println(String.format("start quick sorting of %s elements", maxSize));
		arrayQk.quickSort();

		// Программный проект 7.2 - Program project 7.2
		System.out.println(String.format("quick sorting took %s", Calendar.getInstance().getTime().getTime() - startTime));
		System.out.println(String.format("during the execution of quick sort %s comparisons and %s permutations were performed", arrayQk.getCompares(), arrayQk.getSwaps()));
	}
}
