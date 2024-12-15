package com.tp.tp6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
	Queue<String> fa0, fa1, fa2;

	@Before
	public void setUp() throws Exception {
		fa0 = new Queue<String>();

		fa1 = new Queue<String>();
		fa1.push("plop");

		fa2 = new Queue<String>();
		fa2.push("a");
		fa2.push("b");
	}

	@Test
	public void testIsEmpty() {
		assertTrue(fa0.isEmpty());
		assertFalse(fa1.isEmpty());
	}

	@Test
	public void testPush() {
		assertTrue(fa0.isEmpty());
		fa0.push("toto");
		assertFalse(fa0.isEmpty());
	}

	@Test
	public void testPushNull() {
		try {
			fa0.push(null);
			fail("Expected QueueInvalidElementException to be thrown");
		} catch (QueueNullElementException e) {
			assertEquals("Null elements are not allowed in the queue", e.getMessage());
		}
	}

	@Test
	public void testPop() {
		// exception fail();
		try {
			fa0.pop();
			fail();
		} catch (QueueEmptyException e) {
			// ok
		}
		assertEquals(fa1.pop(), "plop");
		assertTrue(fa1.isEmpty());
		assertEquals(fa2.pop(), "b");
		assertEquals(fa2.pop(), "a");
		assertTrue(fa2.isEmpty());
	}

	@Test
	public void testSize() {
		
	
		assertEquals(fa1.size(), 1);
		assertEquals(fa2.size(), 2);
	}

	@Test
	public void testSizeZero() {
		try {
			fa0.size();
			fail("Expected SizeZeroException to be thrown");
		} catch (QueueEmptyException e) {
			assertEquals("Size cannot be zero", e.getMessage());
		}
	}

	@Test
	public void testFont() {
		// exception fail();
		try {
			fa0.front();
			fail();
		} catch (QueueEmptyException e) {
			// ok
		}
		assertEquals(fa1.front(), "plop");
		assertEquals(fa2.front(), "a");
	}
}
