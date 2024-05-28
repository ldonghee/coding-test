package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

/**
 * 18. 4Sum
 * https://leetcode.com/problems/4sum/
 */
public class Sum4 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		return null;
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
