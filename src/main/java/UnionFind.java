public abstract class UnionFind {

	public UnionFind(int n) {
		elements = new int[n];
		for (int i = 0; i < n; i++) {
			elements[i] = i;
		}
	}

	public int[] getElements() {
		return elements;
	}

	public void setElements(int[] elements) {
		this.elements = elements;
	}

	protected int[] elements;

	abstract public boolean connected(int a, int b);

	abstract public void union(int a, int b);

}
