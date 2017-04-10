package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import bitVector.BitVector;

public class BitVectorTests {

	@Test
	public void testGetAndSet() {
		BitVector bitObj = new BitVector();
		bitObj.set(1);
		bitObj.set(10);
		bitObj.set(32);
		bitObj.set(63);
		bitObj.set(1024);
		assertTrue(bitObj.get(1));
		assertTrue(bitObj.get(10));
		assertTrue(bitObj.get(32));
		assertTrue(bitObj.get(1024));
		assertTrue(bitObj.get(63));
	}
	
	@Test
	public void testClear() {
		BitVector bitObj = new BitVector();
		bitObj.set(1);
		bitObj.set(32);
		bitObj.set(1024);
		bitObj.set(12345);
		assertTrue(bitObj.get(1));
		assertTrue(bitObj.get(32));
		assertTrue(bitObj.get(12345));
		bitObj.clear(32);
		bitObj.clear(12345);
		assertTrue(bitObj.get(1));
		assertTrue(bitObj.get(1024));
		assertFalse(bitObj.get(32));
		assertFalse(bitObj.get(12345));
	}
	
	@Test
	public void testAddAll() {
		BitVector bitObj = new BitVector();
		bitObj.set(1);
		bitObj.set(10);
		assertTrue(bitObj.get(1));
		assertTrue(bitObj.get(10));
		BitVector bitObj2 = new BitVector();
		bitObj2.set(2048);
		bitObj2.set(4096);
		assertTrue(bitObj2.get(2048));
		assertTrue(bitObj2.get(4096));
		bitObj.addAll(bitObj2);
		assertTrue(bitObj.get(2048));
		assertTrue(bitObj.get(4096));
	}
	
	@Test
	public void testIterator() {
		BitVector bitObj = new BitVector();
		bitObj.set(1);
		bitObj.set(10);
		bitObj.set(32);
		bitObj.set(63);
		bitObj.set(1024);
		assertTrue(bitObj.get(1));
		assertTrue(bitObj.get(10));
		assertTrue(bitObj.get(32));
		assertTrue(bitObj.get(1024));
		assertTrue(bitObj.get(63));
		
		bitVector.Iterator<Integer> iter = bitObj.iterator();
		assertTrue(iter.hasAnotherElement());
		assertEquals(1, (int)iter.nextElement());
		assertTrue(iter.hasAnotherElement());
		assertEquals(10, (int)iter.nextElement());
		assertTrue(iter.hasAnotherElement());
		assertEquals(32, (int)iter.nextElement());
		assertTrue(iter.hasAnotherElement());
		assertEquals(63, (int)iter.nextElement());
		assertTrue(iter.hasAnotherElement());
		assertEquals(1024, (int)iter.nextElement());
		assertEquals(true, iter.hasAnotherElement());
	}

}
