package test.neetcode.backtracking;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 494. Target Sum
 * https://leetcode.com/problems/target-sum/description/
 */
public class TargetSum {
	public int findTargetSumWays(int[] nums, int target) {
		return 0;
	}

	@Test
	public void test01() {
		int[] nums = {1, 1, 1, 1, 1};
		int target = 3;
		int expect = 5;
		int actual = findTargetSumWays(nums, target);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test02() {
		int[] nums = {1};
		int target = 1;
		int expect = 1;
		int actual = findTargetSumWays(nums, target);
		assertThat(expect).isEqualTo(actual);
	}
}
