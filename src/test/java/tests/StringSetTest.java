package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import bitVector.Iterator;
import stringset.StringSet;

public class StringSetTest {

	@Test
	public void test() {
		StringSet testStringSet = new StringSet();
		
		testStringSet.add("String 1");
		testStringSet.add("String 2");
		testStringSet.add("String 3");
		testStringSet.add("String 4");
		
		
		/*
		 * Testing StringSet Size
		 */
		assertEquals(4, testStringSet.size());
		
		testStringSet.add("String 5");
		testStringSet.add("String 6");
		testStringSet.add("String 7");
		
		
		/*
		 * Testing StringSet Size
		 */
		assertEquals(7, testStringSet.size());
		
		StringSet testStringSet2 = new StringSet();
		
		testStringSet2.add("String 8");
		testStringSet2.add("String 9");
		
		
		/*
		 * Testing StringSet method addAll
		 */
		testStringSet.addAll(testStringSet2);
		assertEquals(9, testStringSet.size());
		
		/*
		 * Making sure that the two objects contain values and are not null
		 */
		assertNotNull(testStringSet);
		assertNotNull(testStringSet2);
		
		/*
		 * Testing String Set Method remove
		 */
		testStringSet2.remove("String 9");
		assertEquals(1, testStringSet2.size());
	}
	
	@Test
	public void testStringIterator() {
		StringSet testStringSet = new StringSet();
		
		testStringSet.add("String 1");
		testStringSet.add("String 2");
		testStringSet.add("String 3");
		testStringSet.add("String 4");
		
		Iterator<String> iterator = testStringSet.iterator();
		
		/*
		 * Making sure that testStringSet has next element and is not null
		 */
		assertTrue(iterator.hasAnotherElement());
		assertNotNull(iterator.nextElement());
		assertTrue(iterator.hasAnotherElement());
		assertNotNull(iterator.nextElement());
		assertTrue(iterator.hasAnotherElement());
		assertNotNull(iterator.nextElement());
		assertTrue(iterator.hasAnotherElement());
		assertNull(iterator.nextElement());
		assertFalse(iterator.hasAnotherElement());
		
	}

}
