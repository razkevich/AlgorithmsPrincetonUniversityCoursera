import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class RandomizedQueTest {
	@Test
	public void test1() {

		ArrayList<Integer> dequeued = new ArrayList<>();
		new Thread(() -> {
			for (int i = 0; i < 500; i++) {
				RandomizedQueue<Integer> q = new RandomizedQueue<>();
				for (int j = 1; j < 10001; j++) {
					q.enqueue(j);
				}
				dequeueAll(q, dequeued);
			}
		}).start();

	}@Test
	public void test2() {

		RandomizedQueue<Integer> q = new RandomizedQueue<>();
		q.enqueue(897);
		q.enqueue(993);
		q.dequeue();
		q.dequeue();

	}

	private void dequeueAll(RandomizedQueue<Integer> q, ArrayList<Integer> dequeued) {
		Iterator<Integer> itr = q.iterator();
		for (int j = 1; j < 10001; j++) {
			new Thread(() -> {
				dequeue(dequeued, itr);
			}).start();
		}
	}

	private void dequeue(ArrayList<Integer> dequeued, Iterator<Integer> itr) {
		int d = itr.next();
		if (dequeued.contains(d)) {
			org.junit.Assert.fail();
		}
	}
}