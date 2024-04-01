package test.neetcode.binarySearch;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= target) {
				return i;
			}
			if (i == nums.length - 1) {
				return i + 1;
			}
		}
		return 0;
	}

	public int bestSearchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		if (target < nums[left]) {
			return 0;
		}
		if (target > nums[right]) {
			return nums.length;
		}

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	@Test
	public void test() {
		int[] nums = {1, 3, 5, 6};
		int target = 5;

		int expect = 2;
		int actual = bestSearchInsert(nums, target);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test2() {
		int[] nums = {1, 3, 5, 6};
		int target = 2;

		int expect = 1;
		int actual = bestSearchInsert(nums, target);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test3() {
		int[] nums = {1, 3, 5, 6};
		int target = 7;

		int expect = 4;
		int actual = bestSearchInsert(nums, target);
		assertThat(actual).isEqualTo(expect);
	}
}
