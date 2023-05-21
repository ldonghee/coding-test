package test.neetcode.binarySearch;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 875. Koko Eating Bananas
 * https://leetcode.com/problems/koko-eating-bananas/
 * https://neetcode.io/roadmap
 */
public class KokoEatingBananas {
	class Solution {
		public int minEatingSpeed(int[] piles, int h) {


			return 0;
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[] piles = {3,6,7,11};
		int h = 8;

		int expect = 4;
		int actual = solution.minEatingSpeed(piles, h);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[] piles = {30,11,23,4,20};
		int h = 5;

		int expect = 30;
		int actual = solution.minEatingSpeed(piles, h);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		int[] piles = {30,11,23,4,20};
		int h = 6;

		int expect = 23;
		int actual = solution.minEatingSpeed(piles, h);
		assertThat(actual).isEqualTo(expect);
	}
}
