package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

/**
 * 18. 4Sum
 * https://leetcode.com/problems/4sum/
 */
public class Sum4 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Set<List<Integer>> resultSet = new HashSet<>();
		Arrays.sort(nums);

		for (int start = 0; start < nums.length; start++) {
			int end = nums.length - 1;

			while (start < end) {
				int frontSum = target - (nums[start] + nums[end]);

				int midStart = start + 1;
				int midEnd = end - 1;

				while (midStart < midEnd) {
					if (nums[midStart] + nums[midEnd] == frontSum) {
						List<Integer> list = Arrays.asList(nums[start], nums[midStart], nums[midEnd], nums[end]);
						Collections.sort(list);
						resultSet.add(list);

						midEnd = midEnd - 1;
					} else if (nums[midStart] + nums[midEnd] < frontSum) {
						midStart = midStart + 1;
					} else if (nums[midStart] + nums[midEnd] > frontSum) {
						midEnd = midEnd - 1;
					}
				}

				end = end - 1;
			}
		}

		return new ArrayList<>(resultSet);
	}



	@Test
	public void test01() {
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;

		List<List<Integer>> expect = Lists.newArrayList(Lists.newArrayList(-2, -1, 1, 2),
			Lists.newArrayList(-2, 0, 0, 2),
			Lists.newArrayList(-1, 0, 0, 1));
		List<List<Integer>> actual = fourSum(nums, target);
		assertThat(actual.containsAll(expect)).isTrue();
		assertThat(expect.containsAll(actual)).isTrue();
		assertThat(actual.size()).isEqualTo(3);
	}

	@Test
	public void test02() {
		int[] nums = {2, 2, 2, 2, 2};
		int target = 8;

		List<List<Integer>> expect = Arrays.asList(Lists.newArrayList(2, 2, 2, 2));
		List<List<Integer>> actual = fourSum(nums, target);
		assertThat(actual.containsAll(expect)).isTrue();
		assertThat(expect.containsAll(actual)).isTrue();
		assertThat(actual.size()).isEqualTo(1);
	}
}
