package test.neetcode.arrayAndHash;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
	class Solution {
		public int[] twoSum(int[] nums, int target) {
			for (int i=0; i<nums.length-1; i++) {
				for (int j=i+1; j<nums.length; j++) {
					if (nums[i] + nums[j] == target) {
						return new int[] {i, j};
					}
				}
			}

			return null;
		}

		/**
		 * 		***** Best Answer *****
		 *
		 * 		public int[] twoSum(int[] nums, int target) {
		 *         HashMap<Integer, Integer> prevMap = new HashMap<>();
		 *
		 *         for (int i = 0; i < nums.length; i++) {
		 *             int num = nums[i];
		 *             int diff = target - num;
		 *
		 *             if (prevMap.containsKey(diff)) {
		 *                 return new int[] { prevMap.get(diff), i };
		 *             }
		 *
		 *             prevMap.put(num, i);
		 *         }
		 *
		 *         return new int[] {};
		 *     }
		 */
	}



	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[] nums = {2,7,11,15};
		int target = 9;

		int[] expect = {0,1};
		int[] actual = solution.twoSum(nums, target);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[] nums = {3,2,4};
		int target = 6;

		int[] expect = {1,2};
		int[] actual = solution.twoSum(nums, target);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		int[] nums = {3,3};
		int target = 6;

		int[] expect = {0,1};
		int[] actual = solution.twoSum(nums, target);
		assertThat(actual).isEqualTo(expect);
	}
}
