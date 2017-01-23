package org.razkevich.UnionFind;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.razkevich.UnionFind.core.QuickFind;
import org.razkevich.UnionFind.core.QuickUnion;
import org.razkevich.UnionFind.core.UnionFind;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UnionFindTest {

	public static final int N = 10;
	private UnionFind unionFind;

	public UnionFindTest(UnionFind unionFind) {
		this.unionFind = unionFind;
	}

	@Parameters
	public static Collection<UnionFind> initTestCases() throws Exception {
		return Arrays.asList(new QuickUnion(N), new QuickFind(N));
	}

	@Test
	public void test1() {
		unionFind.union(0, 1);
		unionFind.union(1, 7);
		unionFind.union(2, 4);
		unionFind.union(6, 3);
		unionFind.union(5, 3);
		unionFind.union(8, 3);
		Assert.assertTrue(unionFind.connected(0, 7));
		Assert.assertTrue(unionFind.connected(0, 1));
		Assert.assertTrue(unionFind.connected(2, 4));
		Assert.assertTrue(unionFind.connected(3, 5));
		Assert.assertTrue(unionFind.connected(3, 8));
		Assert.assertTrue(unionFind.connected(3, 6));
		Assert.assertFalse(unionFind.connected(3, 0));
		Assert.assertFalse(unionFind.connected(0, 9));
		Assert.assertFalse(unionFind.connected(4, 8));
		Assert.assertFalse(unionFind.connected(4, 1));
		Assert.assertFalse(unionFind.connected(8, 2));
		Assert.assertFalse(unionFind.connected(4, 5));
	}

}