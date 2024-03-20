package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class IntersectionOfTwoArrays2 {
	public int[] intersect(int[] nums1, int[] nums2) {
		return null;
	}

	@Test
	void test1() {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		int[] expect = {2,2};
		int[] actual = intersect(nums1, nums2);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	void test2() {
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		int[] expect = {4,9};
		int[] actual = intersect(nums1, nums2);
		assertThat(expect).isEqualTo(actual);
	}
}
