package test.neetcode.slidingWIndow;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * https://neetcode.io/roadmap
 */
public class BestTimeToBuyAndSellStock {
	class Solution {
		public int maxProfit(int[] prices) {
			int left = 0;
			int right = 1;
			int diff = 0;

			while(right < prices.length) {
				if (prices[left] < prices[right]) {
					diff = Math.max(diff, prices[right] - prices[left]);
				} else {
					left = right;
				}
				right++;
			}

			return diff;
		}
	}
	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[] prices = {7,1,5,3,6,4};

		int expect = 5;
		int actual = solution.maxProfit(prices);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[] prices = {7,6,4,3,1};

		int expect = 0;
		int actual = solution.maxProfit(prices);
		assertThat(actual).isEqualTo(expect);
	}
}
