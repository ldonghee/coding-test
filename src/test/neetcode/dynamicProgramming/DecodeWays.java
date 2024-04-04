package test.neetcode.dynamicProgramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {
	public int numDecodings(String s) {
		return 0;
	}

	@Test
	public void test() {
		String s = "12";
		int expect = 2;
		int actual = numDecodings(s);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test2() {
		String s = "226";
		int expect = 3;
		int actual = numDecodings(s);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test3() {
		String s = "06";
		int expect = 0;
		int actual = numDecodings(s);
		assertThat(actual).isEqualTo(expect);
	}
}
