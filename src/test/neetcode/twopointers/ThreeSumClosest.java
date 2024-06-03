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
		List<Integer> numList = Arrays.stream(nums)
			.boxed()
			.collect(Collectors.toList());
		Collections.sort(numList);

		int left = 0;
		int right = numList.size() - 1;
		int closet = 0;
		while(left < right - 1) {
			int sum = numList.get(left) + numList.get(right);
			if (sum < target) {
				sum += numList.get(right - 1);
			} else {
				sum += numList.get(left + 1);
			}

			if (target - sum == 0) {
				closet = sum;
				break;
			}

			if ((target - closet > target - sum) || (left == 0 && right == numList.size() -1)) {
				closet = sum;
			}

			if (sum < target) {
				left++;
				continue;
			}
			right--;
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
