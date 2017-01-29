import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class PercolationUI {

	public static void main(String[] args) throws IOException {
		final int N = 200, T = 100;
		Map<Float, Float> results = new TreeMap<>();
		for (float p = 0; p <= 1; p += 0.0593F) {
			results.put(p, runOptimization(N, T, p));
		}
		results.entrySet().forEach(e -> System.out.println(String.format("%.3f = %.3f", e.getKey(), e.getValue())));
	}

	private static float runOptimization(int n, int t, float p) {
		int nSquared = n * n;
		boolean[] percolateResults = new boolean[t];
		for (int i = 0; i < t; i++) {
			percolateResults[i] = calculateUnionFind(n, p, nSquared).connected(0, nSquared + 1);
		}
		int sum = 0;
		for (boolean percolateResult : percolateResults) {
			if (percolateResult) sum++;
		}
		return (float) sum / t;
	}

	private static UnionFind calculateUnionFind(int n, float p, int nSquared) {
		boolean openSites[] = new boolean[nSquared + 2];
		UnionFind unionFind = new QuickUnion(nSquared + 2);
		for (int i = 1; i <= n; i++) {
			unionFind.union(i, 0);
			unionFind.union(nSquared + 1 - i, nSquared + 1);
		}
		for (int i = 1; i < nSquared - 1; i++) {
			openSites[i] = new Random().nextFloat() < p;
			if (openSites[i]) {
				if (i - 1 >= 0 && openSites[i - 1]) {
					unionFind.union(i, i - 1);
				}
				if (i - n >= 0 && openSites[i - n]) {
					unionFind.union(i, i - n);
				}
			}
		}
		return unionFind;
	}
}
