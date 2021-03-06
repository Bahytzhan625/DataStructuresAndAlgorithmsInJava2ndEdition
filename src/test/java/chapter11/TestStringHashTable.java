package chapter11;

import base.structures.HashTable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

import static chapter11.TestHashTableBase.HASH_TABLE_SIZE;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестирование сущности {@link StringHashTable}
 *
 * @author bahytzhan
 * @created 04.11.2021
 * @$Author$
 * @$Revision$
 */
public class TestStringHashTable {
	private static StringHashTable hashTable;
	private static StringHashTable secondHashTable;
	private static ArrayList<String> additionalItems;

	{
		additionalItems = new ArrayList<>();
		additionalItems.add("asdasdfg");
		additionalItems.add("Asd");
		additionalItems.add("aaa");
		additionalItems.add("agdfgdbsd");
		additionalItems.add("asdasdasghfgh");
	}

	@BeforeAll
	public void init() {
		hashTable = new StringHashTable(HASH_TABLE_SIZE);
		secondHashTable = new StringHashTable(HASH_TABLE_SIZE);

		Random random = new Random();

		IntStream.range(0, HASH_TABLE_SIZE / 2).forEach(key -> {
			char[] chars = new char[3];
			chars[0] = (char) ('a' + random.nextInt(('z' - 'a') + 1));
			chars[1] = (char) ('a' + random.nextInt(('z' - 'a') + 1));
			chars[2] = (char) ('a' + random.nextInt(('z' - 'a') + 1));
			hashTable.insert(String.valueOf(chars));
			secondHashTable.insert(String.valueOf(chars));
		});
	}

	/**
	 * Тестирование метода проверяющего соответствие символов в передаваемом значении шаблону [a-z]
	 */
	@Test
	public void testLetterMatcher() {
		assertTrue(StringHashTable.isMatchLettersInString("asdasd"));
		assertTrue(StringHashTable.isMatchLettersInString("asasdadasd"));
		assertTrue(StringHashTable.isMatchLettersInString("as"));
		assertTrue(StringHashTable.isMatchLettersInString("a"));

		assertFalse(StringHashTable.isMatchLettersInString("-"));
		assertFalse(StringHashTable.isMatchLettersInString("_dfgdfgdfg"));
		assertFalse(StringHashTable.isMatchLettersInString("asda1asd"));
	}

	@Test
	public void testHashFunction() {
		assertEquals(0, hashTable.hashFunction("a"));
		assertEquals(25, hashTable.hashFunction("z"));
		assertEquals(97, hashTable.hashFunction("cats"));
		assertEquals(112, hashTable.hashFunction("synchrophasotron"));
	}

	@Test
	public void testInsertMethod() {
		hashTable.insert("mother");

		assertEquals("mother", hashTable.find("mother"));

		hashTable.insert("father");

		assertEquals("father", hashTable.find("father"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInsertMethod2() {
		hashTable.insert("_mother");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInsertMethod3() {
		hashTable.insert("mot1her");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInsertMethod4() {
		hashTable.insert("mother ");
	}

	@Test
	public void testDeleteMethod() {
		hashTable.insert("mother");

		String deletedItem = hashTable.delete("mother");

		assertNotNull(deletedItem);
		assertEquals("mother", deletedItem);

		deletedItem = hashTable.delete("mother");
		assertNull(deletedItem);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeleteMethod2() {
		hashTable.delete("_mother");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeleteMethod3() {
		hashTable.delete("mot1her");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeleteMethod4() {
		hashTable.delete("mother ");
	}

	@Test
	public void testGetDisplayDataMethod() {
		TestHashTableBase.testGetDisplayDataMethod(hashTable);
	}

	@Test
	public void checkGettingElementsNumber() {
		TestHashTableBase.checkGettingElementsNumber(hashTable, HASH_TABLE_SIZE / 2, additionalItems);
	}

	@Test
	public void checkHashTableSize() {
		TestHashTableBase.checkHashTableSize(hashTable, HASH_TABLE_SIZE, additionalItems);
	}

	@Test
	public void testGettingLoadFactor() {
		TestHashTableBase.testGettingLoadFactor(hashTable, (HASH_TABLE_SIZE / 2) / (float) HASH_TABLE_SIZE, additionalItems);
	}

	@Test
	public void testRehash() {
		hashTable.insert("asdasda");
		hashTable.insert("asdadfgsda");
		hashTable.insert("hjkhjk");
		hashTable.insert("rtyrr");

		assertEquals(HashTable.getPrime(HASH_TABLE_SIZE * 2), hashTable.getHashArray().length);

		String[] hashArray = secondHashTable.getHashArray();
		for (int i = 0; i < hashArray.length; i++) {
			if (hashArray[i] != null) {
				assertEquals(hashArray[i], hashTable.find(hashArray[i]));
				assertFalse(hashArray[i].equals("-1"));
			}
		}
	}
}
