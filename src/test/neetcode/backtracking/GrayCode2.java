package test.neetcode.backtracking;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 89. Gray Code
 * https://leetcode.com/problems/gray-code/
 */
public class GrayCode2 {
	public List<Integer> grayCode(int n) {
		return null;
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
