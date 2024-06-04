package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/**
 * 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);

		int closet = nums[0] + nums[1] + nums[nums.length-1];

		for (int i=0; i<nums.length-2; i++) {
			int left = i+1;
			int right = nums.length - 1;
			int num = nums[i];

			while (left < right) {
				int sum = nums[left] + nums[right] + num;

				if (sum > target) {
					right--;
				} else if(sum < target) {
					left++;
				} else {
					return target;
				}

				if (Math.abs(sum - target) < Math.abs(closet - target)) {
					closet = sum;
				}
			}
		}

		return closet;
	}

	@Test
	public void test01() {
		int[] nums = {-1, 2, 1, -4};
		int target = 1;
		int expect = 2;

		int actual = threeSumClosest(nums, target);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test02() {
		int[] nums = {0, 0, 0};
		int target = 1;
		int expect = 0;

		int actual = threeSumClosest(nums, target);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test03() {
		int[] nums = {1, 1, -1};
		int target = 2;
		int expect = 1;

		int actual = threeSumClosest(nums, target);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test04() {
		int[] nums = {4,0,5,-5,3,3,0,-4,-5};
		int target = -2;
		int expect = -2;

		int actual = threeSumClosest(nums, target);
		assertThat(expect).isEqualTo(actual);
	}
}
