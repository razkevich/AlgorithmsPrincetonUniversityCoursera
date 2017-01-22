package org.razkevich.UnionFind;

public class QuickFind implements UnionFind {

    private int[] id;

    public int[] getId() {
        return id;
    }

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int a, int b) {
        return id[a] == id[b];
    }

    public void union(int a, int b) {
        for (int i = 0; i < id.length; i++) {
            if (id[i] == id[a]) {
                id[i] = id[b];
            }
        }

    }
}
