package test.neetcode.backtracking;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

/**
 * 47. Permutations II
 * https://leetcode.com/problems/permutations-ii/
 */
public class PermutationsII {
	List<List<Integer>> answers = new ArrayList<>();
	Set<String> uniqueAnswers = new HashSet<>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		boolean[] visited = new boolean[nums.length];
		dfs(nums, visited, new ArrayList<>());
		return answers;
	}

	public void dfs(int[] nums, boolean[] visited, List<Integer> combinations) {
		if (combinations.size() == nums.length) {
			String collect = combinations.stream()
				.map(n -> String.valueOf(n))
				.collect(Collectors.joining());
			if (!uniqueAnswers.contains(collect)) {
				uniqueAnswers.add(collect);
				answers.add(new ArrayList<>(combinations));
			}
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i])
				continue;

			combinations.add(nums[i]);
			visited[i] = true;
			dfs(nums, visited, combinations);
			combinations.remove(combinations.size() - 1);
			visited[i] = false;
		}
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
