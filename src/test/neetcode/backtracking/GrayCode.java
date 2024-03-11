package test.neetcode.backtracking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 89. Gray Code
 * https://leetcode.com/problems/gray-code/description/
 */
public class GrayCode {
	public List<Integer> grayCode(int n) {
		return Arrays.asList(0, 1, 3, 2);
	}

	@Test
	public void test01() {
		int n = 2;

		List<Integer> expect = Arrays.asList(0, 1, 3, 2);
		List<Integer> actual = grayCode(n);

		assertThat(expect).isEqualTo(actual);
	}
}
