package test.neetcode.dynamicProgramming;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

/**
 * 120. Triangle
 * https://leetcode.com/problems/triangle/
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		return 0;
	}

	@Test
	public void test01() {
		List<List<Integer>> triangle = Lists.newArrayList(Lists.newArrayList(2), Lists.newArrayList(3, 4),
														  Lists.newArrayList(6, 5, 7), Lists.newArrayList(4, 1, 8, 3));
		int expect = 11;
		int actual = minimumTotal(triangle);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test02() {
		List<List<Integer>> triangle = Lists.newArrayList(Lists.newArrayList(-10), null);
		int expect = -10;
		int actual = minimumTotal(triangle);
		assertThat(expect).isEqualTo(actual);
	}
}
