package test.neetcode.binarySearch;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				return mid;
			}

			// 왼쪽 정렬이 정상 정렬인 경우 (오름차순)
			if (nums[left] <= nums[mid]) {
				if (nums[left] <= target && nums[mid] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (nums[right] < target && nums[mid] <= target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}

	@Test
	public void test01() {
		int[] nums = {4,5,6,7,0,1,2};
		int target = 0;

		int expect = 4;
		int actual = search(nums, target);

		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test02() {

		int[] nums = {4,5,6,7,0,1,2};
		int target = 3;

		int expect = -1;
		int actual = search(nums, target);

		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test03() {
		int[] nums = {1};
		int target = 0;

		int expect = -1;
		int actual = search(nums, target);

		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test04() {
		int[] nums = {7,0,1,2,4,5,6};
		int target = 0;

		int expect = 1;
		int actual = search(nums, target);

		assertThat(expect).isEqualTo(actual);
	}
}
