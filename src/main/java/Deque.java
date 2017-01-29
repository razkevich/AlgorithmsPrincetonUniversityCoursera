import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private Entry head, tail;
	private int size;

	private class Entry {
		protected Item value;
		protected Entry next, prev;

		public Entry(Item value, Entry next, Entry prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
	}

	public Deque() {
	}

	public boolean isEmpty() {
		return size <= 0;
	}

	public int size() {
		return size;
	}

	public void addFirst(Item item) {
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

	public void addLast(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}
		Entry newEntry = new Entry(item, null, head);
		if (head != null) {
			head.next = newEntry;
		}
		head = newEntry;
		if (tail == null) {
			tail = head;
		}
		size++;

	}

	public Item removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Item oldValue = tail.value;
		tail = tail.next;
		if (--size <= 0) {
			tail = head = null;
		}
		if (isEmpty()){
			head=null;
		}else{
			tail.prev=null;
		}
		return oldValue;
	}

	public Item removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Item oldValue = head.value;
		head = head.prev;
		if (--size <= 0) {
			tail = head = null;
		}
		if (isEmpty()){
			tail=null;
		}else{
			head.next=null;
		}
		return oldValue;
	}

	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			private Entry current = tail;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public Item next() throws NoSuchElementException {
				if (current == null) {
					throw new NoSuchElementException();
				}
				Item item = current.value;
				current = current.next;
				return item;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("remove");
			}

		};
	}
}