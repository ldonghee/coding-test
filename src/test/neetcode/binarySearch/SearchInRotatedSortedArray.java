package test.neetcode.binarySearch;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		return 0;
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
}
