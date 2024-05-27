package test.neetcode.backtracking;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

/**
 * 47. Permutations II
 * https://leetcode.com/problems/permutations-ii/
 */
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		return null;
	}

	@Test
	public void test01() {
		int[] nums = {1, 1, 2};

		List<List<Integer>> expect = Lists.newArrayList(Lists.newArrayList(1, 1, 2), Lists.newArrayList(1, 2, 1),
			Lists.newArrayList(2, 1, 1));
		List<List<Integer>> actual = permuteUnique(nums);
		assertThat(actual.containsAll(expect)).isTrue();
		assertThat(expect.containsAll(actual)).isTrue();
		assertThat(actual.size()).isEqualTo(3);
	}

	@Test
	public void test02() {
		int[] nums = {1, 2, 3};

		List<List<Integer>> expect = Lists.newArrayList(Lists.newArrayList(1, 2, 3),
			Lists.newArrayList(1, 3, 2),
			Lists.newArrayList(2, 1, 3),
			Lists.newArrayList(2, 3, 1),
			Lists.newArrayList(3, 1, 2),
			Lists.newArrayList(3, 2, 1));
		List<List<Integer>> actual = permuteUnique(nums);
		assertThat(actual.containsAll(expect)).isTrue();
		assertThat(expect.containsAll(actual)).isTrue();
		assertThat(actual.size()).isEqualTo(6);
	}
}
