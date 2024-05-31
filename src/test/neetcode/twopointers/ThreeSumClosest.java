package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		return 0;
	}

	@Test
	public void test01() {
		int[] nums = {-1,2,1,-4};
		int target = 1;
		int expect = 2;

		int actual = threeSumClosest(nums, target);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test02() {
		int[] nums = {0,0,0};
		int target = 1;
		int expect = 0;

		int actual = threeSumClosest(nums, target);
		assertThat(expect).isEqualTo(actual);
	}
}
