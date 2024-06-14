package test.neetcode.backtracking;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 494. Target Sum
 * https://leetcode.com/problems/target-sum/description/
 */
public class TargetSum {
	int count = 0;
	public int findTargetSumWays(int[] nums, int target) {
		dfs(nums, target, 0, 0);
		return count;
	}

	void dfs(int[] nums, int target, int depth, int sum) {
		if (depth == nums.length) {
			if (target == sum) {
				count += 1;
			}
			return;
		}

		dfs(nums, target, depth+1, sum + nums[depth]);
		dfs(nums, target, depth+1, sum - nums[depth]);
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
