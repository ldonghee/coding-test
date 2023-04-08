package test.neetcode.backtracking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/
 * https://neetcode.io/roadmap
 */
public class CombinationSum {
	class Solution {
		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			List<List<Integer>> answers = new ArrayList<>();

			backtracking(candidates, target, answers, new ArrayList<>(), 0);

			return answers;
		}
	}
	public void backtracking(int[] candidates, int target, List<List<Integer>> answers, List<Integer> temp, int idx) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			answers.add(new ArrayList<>(temp));
			return;
		}
		for (int i = idx; i < candidates.length; i++) {
			temp.add(candidates[i]);
			backtracking(candidates, target - candidates[i], answers, temp, i);
			temp.remove(temp.size() - 1);
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[] candidates = {2,3,6,7};
		int target = 7;

		List<List<Integer>> expect = Lists.newArrayList(Lists.newArrayList(2,2,3), Lists.newArrayList(7));
		List<List<Integer>> actual = solution.combinationSum(candidates, target);
		assertThat(actual.containsAll(expect)).isTrue();
		assertThat(expect.containsAll(actual)).isTrue();
		assertThat(actual.size()).isEqualTo(2);
	}

	@Test
	public void test02() {
		int[] candidates = {2,3,5};
		int target = 8;

		List<List<Integer>> expect = Lists.newArrayList(Lists.newArrayList(2,2,2,2), Lists.newArrayList(2,3,3), Lists.newArrayList(3,5));
		List<List<Integer>> actual = solution.combinationSum(candidates, target);
		assertThat(actual.containsAll(expect)).isTrue();
		assertThat(expect.containsAll(actual)).isTrue();
		assertThat(actual.size()).isEqualTo(3);
	}

}
