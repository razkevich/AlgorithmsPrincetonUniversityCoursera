import junit.framework.Assert;
import org.junit.Test;

import java.util.Iterator;

public class DequeTest {
	@Test
	public void test1() {
		Deque<Integer> deque = new Deque<>();
		deque.addFirst(1);
		Assert.assertEquals(1, (int) deque.removeFirst());
		deque.addFirst(1);
		Assert.assertFalse(deque.isEmpty());
		deque.addFirst(2);
		deque.addFirst(3);
		Assert.assertEquals(3, (int) deque.removeFirst());
		Assert.assertEquals(2, (int) deque.removeFirst());
		Assert.assertEquals(1, (int) deque.removeFirst());
		deque.addFirst(4);
		deque.addFirst(5);
		Assert.assertEquals(5, (int) deque.removeFirst());
		Assert.assertFalse(deque.isEmpty());
		Assert.assertEquals(4, (int) deque.removeFirst());
		Assert.assertTrue(deque.isEmpty());
	}

	@Test
	public void test2() {
		Deque<Integer> deque = new Deque<>();
		deque.addLast(1);
		Assert.assertEquals(1, (int) deque.removeLast());
		deque.addLast(1);
		Assert.assertFalse(deque.isEmpty());
		deque.addLast(2);
		deque.addLast(3);
		Assert.assertEquals(3, (int) deque.removeLast());
		Assert.assertEquals(2, (int) deque.removeLast());
		Assert.assertEquals(1, (int) deque.removeLast());
		deque.addLast(4);
		deque.addLast(5);
		Assert.assertEquals(5, (int) deque.removeLast());
		Assert.assertFalse(deque.isEmpty());
		Assert.assertEquals(4, (int) deque.removeLast());
		Assert.assertTrue(deque.isEmpty());
	}

	@Test
	public void test3() {
		Deque<Integer> deque = new Deque<>();
		deque.addLast(1);
		Assert.assertEquals(1, (int) deque.removeFirst());
		deque.addLast(1);
		Assert.assertFalse(deque.isEmpty());
		deque.addLast(2);
		deque.addLast(3);
		Assert.assertEquals(1, (int) deque.removeFirst());
		Assert.assertEquals(2, (int) deque.removeFirst());
		Assert.assertEquals(3, (int) deque.removeFirst());
		deque.addLast(4);
		deque.addLast(5);
		Assert.assertEquals(4, (int) deque.removeFirst());
		Assert.assertFalse(deque.isEmpty());
		Assert.assertEquals(5, (int) deque.removeFirst());
		Assert.assertTrue(deque.isEmpty());
	}

	@Test
	public void test4() {
		Deque<Integer> deque = new Deque<>();
		deque.addFirst(1);
		Assert.assertEquals(1, (int) deque.removeLast());
		deque.addFirst(1);
		Assert.assertFalse(deque.isEmpty());
		deque.addFirst(2);
		deque.addFirst(3);
		Assert.assertEquals(1, (int) deque.removeLast());
		Assert.assertEquals(2, (int) deque.removeLast());
		Assert.assertEquals(3, (int) deque.removeLast());
		deque.addFirst(4);
		deque.addFirst(5);
		Assert.assertEquals(4, (int) deque.removeLast());
		Assert.assertFalse(deque.isEmpty());
		Assert.assertEquals(5, (int) deque.removeLast());
		Assert.assertTrue(deque.isEmpty());
	}

	@Test
	public void test5() {
		Deque<Integer> deque = new Deque<>();
		deque.addFirst(1);
		deque.addFirst(2);
		deque.addLast(3);
		deque.addFirst(4);
		deque.addLast(5);
		deque.addFirst(6);
		deque.addLast(7);
		deque.addFirst(8);
		deque.addLast(9);
		deque.addLast(10);
		Assert.assertEquals(10, (int) deque.removeLast());
		Assert.assertEquals(9, (int) deque.removeLast());
		Assert.assertEquals(7, (int) deque.removeLast());
		Assert.assertEquals(5, (int) deque.removeLast());
		Assert.assertEquals(3, (int) deque.removeLast());
		Assert.assertEquals(1, (int) deque.removeLast());
		Assert.assertEquals(2, (int) deque.removeLast());
		Assert.assertEquals(4, (int) deque.removeLast());
		Assert.assertEquals(6, (int) deque.removeLast());
		Assert.assertEquals(8, (int) deque.removeLast());
	}

	@Test
	public void test6() {
		Deque<Integer> deque = new Deque<>();
		deque.addFirst(1);
		deque.addFirst(2);
		deque.addLast(3);
		deque.addFirst(4);
		deque.addLast(5);
		deque.addFirst(6);
		deque.addLast(7);
		deque.addFirst(8);
		deque.addLast(9);
		deque.addLast(10);
		Assert.assertEquals(8, (int) deque.removeFirst());
		Assert.assertEquals(6, (int) deque.removeFirst());
		Assert.assertEquals(4, (int) deque.removeFirst());
		Assert.assertEquals(2, (int) deque.removeFirst());
		Assert.assertEquals(1, (int) deque.removeFirst());
		Assert.assertEquals(3, (int) deque.removeFirst());
		Assert.assertEquals(5, (int) deque.removeFirst());
		Assert.assertEquals(7, (int) deque.removeFirst());
		Assert.assertEquals(9, (int) deque.removeFirst());
		Assert.assertEquals(10, (int) deque.removeFirst());
	}

	@Test
	public void test7() {
		Deque<Integer> deque = new Deque<>();
		deque.addFirst(0);
		deque.removeFirst();
		deque.addFirst(4);
		deque.addLast(5);
		deque.addLast(6);
		deque.removeFirst();
		deque.removeFirst();
	}

	@Test
	public void test8() {
		Deque<Integer> deque = new Deque<>();
//		/deque.removeFirst();
		//	deque.removeLast();
	}

	@Test
	public void test9() {
		Deque<Integer> deque = new Deque<>();
		deque.addFirst(0);
		deque.addFirst(1);
		deque.addFirst(2);
		deque.addFirst(3);
		deque.addFirst(4);
		deque.addFirst(5);
		for (Integer i : deque) {
			org.junit.Assert.assertNotNull(i);
		}
	}

	@Test
	public void test10() {
		Deque<Integer> deque = new Deque<>();
		deque.addFirst(0);
		deque.addFirst(1);
		deque.addFirst(2);
		deque.addFirst(3);
		deque.addFirst(4);
		deque.addFirst(5);
		Iterator<Integer> iterator = deque.iterator();
		org.junit.Assert.assertEquals(5, (int) iterator.next());
		org.junit.Assert.assertEquals(4, (int) iterator.next());
		org.junit.Assert.assertEquals(3, (int) iterator.next());
		org.junit.Assert.assertEquals(2, (int) iterator.next());
		org.junit.Assert.assertEquals(1, (int) iterator.next());
		org.junit.Assert.assertEquals(0, (int) iterator.next());
	}

	@Test
	public void test11() {
		Deque<Integer> deque = new Deque<>();
		deque.addFirst(0);
		deque.addFirst(1);
		deque.addFirst(2);
		deque.addFirst(3);
		deque.addFirst(4);
		deque.addFirst(5);
		Iterator<Integer> i1 = deque.iterator();
		Iterator<Integer> i2 = deque.iterator();
		while (i1.hasNext())
			while (i2.hasNext())
				System.out.println(i1.next() + ":" + i2.next());
	}

	@Test
	public void test12() {
		Deque<Integer> deque = new Deque<>();
		deque.addFirst(0);
		deque.addFirst(1);
		deque.addFirst(2);
		deque.addFirst(3);
		deque.addFirst(4);
		deque.addFirst(5);
		Iterator<Integer> i1 = deque.iterator();
		Iterator<Integer> i2 = deque.iterator();
		while (i1.hasNext())
			while (i2.hasNext())
				System.out.println(i1.next() + ":" + i2.next());
	}

	@Test
	public void test13() {
		Deque<Integer> deque = new Deque<>();
		deque.addLast(1);
		deque.removeLast();
		deque.addLast(3);
		deque.addFirst(4);
		deque.addLast(5);
		deque.removeLast();
		deque.iterator().next();
		deque.iterator().next();
		deque.iterator().next();
	}
}