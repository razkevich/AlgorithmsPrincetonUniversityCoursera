import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Entry head, tail;

	private class Entry {

		protected Item value;
		protected Entry next, prev;

		public Entry(Item value, Entry next, Entry prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
	}

	private int size;

	public void enqueue(Item item) {
		addFirst(item);
	}

	public Item sample() {
		return getRandomEntry().value;
	}

	public synchronized Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Entry randomEntry = getRandomEntry();
		if (randomEntry.next != null) {
			randomEntry.next.prev = randomEntry.prev;
		}
		if (randomEntry.prev != null) {
			randomEntry.prev.next = randomEntry.next;
		}
		size--;
		return randomEntry.value;
	}

	private Entry getRandomEntry() {
		int min = 0, max = size() - 1;
		int index = (int) Math.round(StdRandom.uniform() * (max - min) + min);
		Entry element = tail;
		for (int i = 1; i <= index; i++) {
			element = element.next;
		}
		return element;
	}

	public boolean isEmpty() {
		return size <= 0;
	}

	public int size() {
		return size;
	}

	private void addFirst(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}
		final Entry newEntry = new Entry(item, tail, null);
		if (tail != null) {
			tail.prev = newEntry;
		}
		tail = newEntry;

		if (head == null) {
			head = tail;
		}
		size++;
	}

	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			@Override
			public boolean hasNext() {
				return !isEmpty();
			}

			@Override
			public Item next() throws NoSuchElementException {
				if (isEmpty()) {
					throw new NoSuchElementException();
				}
				return dequeue();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("remove");
			}

		};

	}
}
