package chapter11;

import base.items.LinkItem;
import base.structures.HashTable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static chapter11.TestHashTableBase.HASH_TABLE_SIZE;

/**
 * Тестирование сущности {@link HashChain}
 *
 * @author bahytzhan
 * @created 31.10.2021
 * @$Author$
 * @$Revision$
 */
public class TestHashChain {
	private static HashTable<LinkItem> hashChain;
	private static ArrayList<Link> additionalItems;

	{
		additionalItems = new ArrayList<>();
		IntStream.range(100_000, 100_010).forEach((value) -> additionalItems.add(new Link(value)));
	}

	@BeforeAll
	public void init() {
		hashChain = new HashChain(HASH_TABLE_SIZE);

		IntStream.range(0, HASH_TABLE_SIZE / 2).forEach(key -> hashChain.insert(new Link(key)));
	}

	@Test
	public void testHashFunction() {
		assert
	}
}
