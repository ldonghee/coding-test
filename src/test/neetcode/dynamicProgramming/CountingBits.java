package test.neetcode.dynamicProgramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 338. Counting Bits
 * https://leetcode.com/problems/counting-bits/description/
 */
public class CountingBits {
	public int[] countBits(int n) {
		int[] answers = new int[n + 1];
		for (int i=0; i<=n; i++) {
			int count = 0;
			String s = Integer.toBinaryString(i);
			for (int j=0; j<s.length(); j++) {
				if ('1' == (s.charAt(j))) {
					count++;
				}
			}
			answers[i] = count;

		}
		return answers;
	}

	public int[] countBits2(int num) {
		int[] f = new int[num + 1];
		for (int i=1; i<=num; i++) {
			f[i] = f[i >> 1] + (i & 1);
		}
		return f;
	}

	@Test
	void test1() {
		int n = 2;
		int[] expect = {0,1,1};
		int[] actual = countBits2(n);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	void test2() {
		int n = 5;
		int[] expect = {0,1,1,2,1,2};
		int[] actual = countBits2(n);
		assertThat(expect).isEqualTo(actual);
	}
}
