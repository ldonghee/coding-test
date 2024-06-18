package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/description/
 */
public class RotateArray {
	public int[] rotate(int[] nums, int k) {
		return null;
	}

	@Test
	public void test01() {
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		int[] expect = {5,6,7,1,2,3,4};
		int[] actual = rotate(nums, k);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test02() {
		int[] nums = {-1,-100,3,99};
		int k = 2;
		int[] expect = {3,99,-1,-100};
		int[] actual = rotate(nums, k);
		assertThat(expect).isEqualTo(actual);
	}
}
