package exam.todayhouse.study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

/**
 * 77. Combinations
 * https://leetcode.com/problems/combinations/
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Recursive01 {
	class Solution {
		public List<List<Integer>> combine(int n, int k) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();

			backTracking(result, new ArrayList<>(), 1, n, k);

			System.out.println("result : " + result.toString());
			return result;
 		}

		public void backTracking(List<List<Integer>> result, List<Integer> comb, int value, int n, int combCount) {
			System.out.println("result : " + result.toString() + ", comb : " + comb.toString() + ", value : " + value + ", combCount : " + combCount);

			if (combCount == 0) {
				result.add(new ArrayList<>(comb));
				return;
			}

			for (int i=value; i<n+1; i++) {
				comb.add(i);
				backTracking(result, comb, i+1, n, combCount-1);
				comb.remove(comb.size() - 1);
			}
		}


		/*
		public List<List<Integer>> combine(int n, int k) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			backTracking(result, new ArrayList<Integer>(), 1, n, k);
			return result;
		}

		public  void backTracking(List<List<Integer>> result, List<Integer> comb, int start, int n, int level) {
			System.out.println("result : " + result.toString());
			System.out.println("comb : " + comb.toString() + ", start : " + start + ", level : " + level);
			if (level == 0) { //ending case
				result.add(new ArrayList<Integer>(comb));
				return;
			}

			for (int i = start; i <= n-level+1; i++) {
				comb.add(i);
				backTracking(result, comb, i+1, n, level-1);
				comb.remove(comb.size() - 1);
			}
		}
		*/
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int n = 4;
		int k = 2;

		List<List<Integer>> expect =
				Lists.newArrayList(Lists.newArrayList(1, 2),
								   Lists.newArrayList(1, 3),
								   Lists.newArrayList(1, 4),
								   Lists.newArrayList(2, 3),
								   Lists.newArrayList(2, 4),
								   Lists.newArrayList(3, 4));

		List<List<Integer>> actual = solution.combine(n, k);
		assertThat(actual.containsAll(expect)).isTrue();
		assertThat(expect.containsAll(actual)).isTrue();
		assertThat(actual.size()).isEqualTo(expect.size());
	}

	@Test
	public void test02() {
		int n = 1;
		int k = 1;

		List<List<Integer>> expect = new ArrayList<>();
		expect.add(Lists.newArrayList(1));

		List<List<Integer>> actual = solution.combine(n, k);
		assertThat(actual.containsAll(expect)).isTrue();
		assertThat(expect.containsAll(actual)).isTrue();
		assertThat(actual.size()).isEqualTo(expect.size());
	}

}
