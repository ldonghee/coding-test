package test.neetcode.dynamicProgramming;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

/**
 * 120. Triangle
 * https://leetcode.com/problems/triangle/
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {

		int[] sum = new int[triangle.size() + 1];

		for (int i=triangle.size()-1; i>=0; i--) {
			List<Integer> list = triangle.get(i);

			for (int j=0; j<list.size(); j++) {
				int min = Math.min(sum[j], sum[j + 1]);
				sum[j] = min + list.get(j);
			}
		}

		return sum[0];
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
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(Lists.newArrayList(-10));
		int expect = -10;
		int actual = minimumTotal(triangle);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test03() {
		List<List<Integer>> triangle = Lists.newArrayList(Lists.newArrayList(-1), Lists.newArrayList(2, 3),
			Lists.newArrayList(1, -1, -3));
		int expect = -1;
		int actual = minimumTotal(triangle);
		assertThat(expect).isEqualTo(actual);
	}
}
