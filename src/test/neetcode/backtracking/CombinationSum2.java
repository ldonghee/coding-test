package test.neetcode.backtracking;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum2 {
	List<List<Integer>> combinations = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		dfs(new ArrayList<>(), 0, 0, candidates, target);

		return combinations;
	}

	void dfs (List<Integer> combination, int sum, int index, int[] candidates, int target) {
		if (sum > target) {
			return;
		}
		if (sum == target) {
			combinations.add(new ArrayList<>(combination));
			return;
		}
		for (int i=index; i<candidates.length; i++) {
			combination.add(candidates[i]);
			dfs(combination, sum + candidates[i], i, candidates, target);
			combination.remove(combination.size() - 1);
		}
	}

	@Test
	void test1() {
		int[] nums = {2, 3, 6, 7};
		int target = 7;
		List<List<Integer>> expect =
			Lists.newArrayList(Lists.newArrayList(2, 2, 3), Lists.newArrayList(7));
		List<List<Integer>> actual = combinationSum(nums, target);
		assertThat(actual.containsAll(expect)).isTrue();
		assertThat(expect.containsAll(actual)).isTrue();
	}

	@Test
	void test2() {
		int[] nums = {2, 3, 5};
		int target = 8;
		List<List<Integer>> expect =
			Lists.newArrayList(Lists.newArrayList(2, 2, 2, 2), Lists.newArrayList(2, 3, 3), Lists.newArrayList(3, 5));
		List<List<Integer>> actual = combinationSum(nums, target);
		assertThat(actual.containsAll(expect)).isTrue();
		assertThat(expect.containsAll(actual)).isTrue();
	}

	@Test
	void test3() {
		int[] nums = {2};
		int target = 1;
		List<List<Integer>> expect = Lists.newArrayList();
		List<List<Integer>> actual = combinationSum(nums, target);
		assertThat(actual.containsAll(expect)).isTrue();
		assertThat(expect.containsAll(actual)).isTrue();
	}
}
