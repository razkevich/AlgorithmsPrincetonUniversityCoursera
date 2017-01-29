public class QuickFind extends UnionFind {

	public QuickFind(int n) {
		super(n);
	}

	public boolean connected(int a, int b) {
		return elements[a] == elements[b];
	}

	public void union(int a, int b) {
		for (int i = 0; i < elements.length; i++) {
			int elementA = elements[a], elementB = elements[b];
			if (elements[i] == elementA) {
				elements[i] = elementB;
			}
		}

	}
}
