package test.neetcode.interview;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.print.Pageable;

import org.junit.jupiter.api.Test;

public class NextPermutation_2 {
	public int[] nextPermutation(int[] nums) {
		int idx = nums.length - 2;
		while (idx >= 0 && nums[idx + 1] <= nums[idx]) {
			idx--;
		}


		if (idx >= 0) {
			int changeIdx = nums.length - 1;
			while (nums[changeIdx] <= nums[idx]) {
				changeIdx--;
			}
			swap(nums, idx, changeIdx);
		}

		int i = idx+1, j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}

		return nums;
	}

	public void swap(int[]nums, int idx, int idx2) {
		int temp = nums[idx2];
		nums[idx2] = nums[idx];
		nums[idx] = temp;
	}

	@Test
	public void test01() {
		int[] nums = {1,2,3};
		int[] actual = {1,3,2};
		int[] expect = nextPermutation(nums);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[] nums = {3,2,1};
		int[] acutal = {1,2,3};
		int[] expect = nextPermutation(nums);

		assertThat(acutal).isEqualTo(expect);
	}

	@Test
	public void test03() {
		int[] nums = {1,1,5};
		int[] actual = {1,5,1};
		int[] expect = nextPermutation(nums);

		assertThat(actual).isEqualTo(expect);
	}
}
