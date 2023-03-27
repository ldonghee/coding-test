package test.neetcode.backtracking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

/**
 * 78. Subsets
 * https://leetcode.com/problems/subsets/
 * https://neetcode.io/roadmap
 */
public class Subsets {
	class Solution {
		public List<List<Integer>> subsets(int[] nums) {
			List<List<Integer>> answers = new ArrayList<>();

			backtracking(answers, new ArrayList<Integer>(), nums, 0);

			return answers;
		}

		public void backtracking(List<List<Integer>> rst, ArrayList<Integer> list, int[] nums, int idx) {
			System.out.println("backtracking begin : " + list);
			rst.add(new ArrayList<>(list));

			for (int i = idx; i < nums.length; i++) { // startIndex를 통해 이미 추가한 원소 필터링
				list.add(nums[i]);
				System.out.println("for begin  index : " + i + ", list : " + list.toString());
				backtracking(rst, list, nums, i + 1);
				System.out.println("list remove - num : " + list.get(list.size() - 1));
				list.remove(list.size() - 1);
			}
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[] nums = {1,2,3};

		List<List<Integer>> expect =
				Lists.newArrayList(Lists.newArrayList(), Lists.newArrayList(1), Lists.newArrayList(2), Lists.newArrayList(1, 2),
								   Lists.newArrayList(3),
								   Lists.newArrayList(1, 3), Lists.newArrayList(2, 3), Lists.newArrayList(1, 2, 3));
		List<List<Integer>> actual = solution.subsets(nums);
		assertThat(actual.containsAll(expect));
		assertThat(expect.containsAll(actual));
	}

	@Test
	public void test02() {
		List<List<Integer>> expect =
				Lists.newArrayList(Lists.newArrayList(), Lists.newArrayList(1), Lists.newArrayList(2), Lists.newArrayList(1, 2),
								   Lists.newArrayList(3),
								   Lists.newArrayList(1, 3), Lists.newArrayList(2, 3), Lists.newArrayList(1, 2, 3));


		assertThat(expect.contains(Lists.newArrayList(3))).isTrue();
		assertThat(expect.contains(Lists.newArrayList(2, 3))).isTrue();
		assertThat(expect.contains(Lists.newArrayList(1, 2, 3))).isTrue();
	}

}
