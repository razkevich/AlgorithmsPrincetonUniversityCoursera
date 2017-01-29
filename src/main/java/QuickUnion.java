public class QuickUnion extends UnionFind {

	public QuickUnion(int n) {
		super(n);
	}

	public boolean connected(int a, int b) {
		return getRoot(a) == getRoot(b);
	}

	public void union(int a, int b) {
		elements[getRoot(a)] = getRoot(b);
	}

	private int getRoot(int index) {
		while (elements[index] != index) {
			index = elements[index];
		}
		return index;
	}
}
