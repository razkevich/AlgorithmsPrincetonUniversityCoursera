import java.util.Arrays;

public class SuccessorWithDelete {
	static class SuccessorWithDeleteStructure implements Comparable {
		boolean deleted = false;

		public SuccessorWithDeleteStructure(int value, SuccessorWithDeleteStructure next) {
			this.value = value;
			this.prev = next;
		}

		int value;
		SuccessorWithDeleteStructure prev, next;

		@Override
		public boolean equals(Object o) {
			return !(o == null || !(o instanceof SuccessorWithDeleteStructure))
					&& this.value == ((SuccessorWithDeleteStructure) o).value;
		}

		@Override
		public int compareTo(Object o) {
			return ((Integer) this.value).compareTo(((SuccessorWithDeleteStructure) o).value);
		}
	}


	static int remove(SuccessorWithDeleteStructure[] values, int a) {
		int index = Arrays.binarySearch(values, new SuccessorWithDeleteStructure(a, null));
		if (index < 0 || values[index].deleted) {
			return -1;
		}
		SuccessorWithDeleteStructure current = values[index];
		current.prev.next = current.next;
		current.deleted = true;
		return current.next.value;
	}

}
