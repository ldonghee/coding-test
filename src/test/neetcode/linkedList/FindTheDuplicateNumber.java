package test.neetcode.linkedList;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 287. Find the Duplicate Number
 * https://leetcode.com/problems/find-the-duplicate-number/
 * https://neetcode.io/roadmap
 */
public class FindTheDuplicateNumber {
	class Solution {
		public int findDuplicate(int[] nums) {
			int fast = nums[0];
			int slow = nums[0];
			boolean first = true;
			while (first || fast != slow) {
				if (first) {
					first = false;
				}

				slow = nums[slow];
				fast = nums[nums[fast]];

				if (fast == slow) {
					break;
				}
			}
			int slow2 = nums[0];
			while (slow2 != slow) {
				if (first) {
					first = false;
				}

				slow2 = nums[slow2];
				slow = nums[slow];

				if (slow2 == slow) {
					return slow;
				}
			}
			return slow;
		}

		/*
		public int findDuplicate(int[] nums) {

			Map<Integer, Integer> map = new HashMap<>();

			for (int num : nums) {
				Integer count = map.getOrDefault(num, 0) + 1;
				if (count > 1) {
					return num;
				}
				map.put(num, count);
			}
			return 0;
		}
		*/
	}

	private final Solution solution = new Solution();


	@Test
	public void test01() {
		int[] nums = {1,3,4,2,2};

		int expect = 2;
		int actual = solution.findDuplicate(nums);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[] nums = {3,1,3,4,2};

		int expect = 3;
		int actual = solution.findDuplicate(nums);
		assertThat(actual).isEqualTo(expect);
	}
}
