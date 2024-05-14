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

		// 1. 시작점으로 모든 요소 접근
		for (int i=0; i<candidates.length; i++) {
			dfs(new ArrayList<>(), 0, i, candidates, target);
		}
		// 2. target 값보다 작다면

		return combinations;
	}

	void dfs (List<Integer> combination, int sum, int index, int[] candidates, int target) {
		if (index > candidates.length-1) {
			return;
		}

		int newSum = sum + candidates[index];
		if (newSum < target) {
			dfs(combination, newSum,  index, candidates, target);
		}
		if (newSum == target) {
			combination.add(index);
			combinations.add(combination);
			return;

		}
		dfs(combination, sum, index + 1, candidates, target);
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
