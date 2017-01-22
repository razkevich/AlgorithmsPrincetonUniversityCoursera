package org.razkevich.UnionFind;

public interface UnionFind {
    boolean connected(int a, int b);

    void union(int a, int b);

    int[] getId();
}
