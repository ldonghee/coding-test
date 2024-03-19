package test.neetcode.dynamicProgramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 338. Counting Bits
 * https://leetcode.com/problems/counting-bits/description/
 */
public class CountingBits {
	public int[] countBits(int n) {
		return null;
	}

	@Test
	void test1() {
		int n = 2;
		int[] expect = {0,1,1};
		int[] actual = countBits(n);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	void test2() {
		int n = 5;
		int[] expect = {0,1,1,2,1,2};
		int[] actual = countBits(n);
		assertThat(expect).isEqualTo(actual);
	}
}
