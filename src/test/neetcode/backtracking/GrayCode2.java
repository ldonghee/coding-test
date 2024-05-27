package test.neetcode.backtracking;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 89. Gray Code
 * https://leetcode.com/problems/gray-code/
 */
public class GrayCode2 {
	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<>();
		result.add(0);
		dfs(result, n);
		return result;
	}

	private void dfs(List<Integer> result, int n) {
		if (n == 0) {
			return;
		}

		int size = result.size();
		for (int i = size - 1; i >= 0; i--) {
			result.add(result.get(i) ^ (1 << (n - 1)));
		}

		dfs(result, n - 1);
	}

	@Test
	public void test01() {
		int n = 2;

		List<Integer> expect = Arrays.asList(0,1,3,2);
		List<Integer> actual = grayCode(n);

		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test02() {
		int n = 1;

		List<Integer> expect = Arrays.asList(0, 1);
		List<Integer> actual = grayCode(n);

		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test03() {
		int n = 3;

		List<Integer> expect = Arrays.asList(0, 1, 3, 2, 6, 7, 5, 4);
		List<Integer> actual = grayCode(n);

		assertThat(expect).isEqualTo(actual);
	}
}
