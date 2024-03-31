package test.neetcode.binarySearch;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
		return 0;
	}

	@Test
	public void test() {
		int[] nums = {1,3,5,6};
		int target = 5;

		int expect = 2;
		int actual = searchInsert(nums, target);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test2() {
		int[] nums = {1,3,5,6};
		int target = 2;

		int expect = 1;
		int actual = searchInsert(nums, target);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test3() {
		int[] nums = {1,3,5,6};
		int target = 7;

		int expect = 4;
		int actual = searchInsert(nums, target);
		assertThat(actual).isEqualTo(expect);
	}
}
