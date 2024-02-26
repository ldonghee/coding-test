package test.neetcode.interview;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> answers = new LinkedList<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
//			if (i > 0 && nums[i] == nums[i-1]) {
//				continue;
//			}

			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[left] + nums[right] + nums[i];

				if (sum == 0) {
					answers.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					while (nums[left] == nums[left - 1] && left < right) {
						left++;
					}
					while (nums[right] == nums[right + 1] && left < right) {
						right--;
					}
				} else if (sum > 0) {
					right--;
				} else {
					left++;
				}
			}
		}

		return answers;
	}


	@Test
	public void test01() {
		/*
		 * 	nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
		 * 	nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
		 * 	nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
		 */
		int[] nums = {-1,0,1,2,-1,-4};

		List<List<Integer>> expect = Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1,0,1));
		List<List<Integer>> actual = threeSum(nums);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test02() {
		int[] nums = {0,1,1};

		List<List<Integer>> expect = new ArrayList<>();
		List<List<Integer>> actual = threeSum(nums);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test03() {
		int[] nums = {0,0,0};

		List<List<Integer>> expect = Arrays.asList(Arrays.asList(0,0,0));
		List<List<Integer>> actual = threeSum(nums);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test04() {
		int[] nums = {-2,0,0,2,2};

		List<List<Integer>> expect = Arrays.asList(Arrays.asList(-2,0,2));
		List<List<Integer>> actual = threeSum(nums);
		assertThat(expect).isEqualTo(actual);
	}
}
