package test.programmers.dynamicProgramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * N으로 표현
 * https://school.programmers.co.kr/learn/courses/30/lessons/42895
 */
public class Dp01 {

	class Solution {
		int min = Integer.MAX_VALUE;

		public int solution(int N, int number) {
			dfs(0, N, number, 0);

			if (min == Integer.MAX_VALUE) return -1;
			return min;
		}

		public void dfs(int depth, int N, int number, int current) {
			if (depth > 8) {
				return;
			}

			if (number == current) {
				min = Math.min(depth, min);
				return;
			}

			int temp = 0;

			for (int i = 0; i < 8; i++) {
				if (depth + i < 8) {
					temp = temp * 10 + N;
					dfs(depth + i + 1, N, number, current + temp);
					dfs(depth + i + 1, N, number, current - temp);
					dfs(depth + i + 1, N, number, current / temp);
					dfs(depth + i + 1, N, number, current * temp);
				}
			}
		}
	}


	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int N = 5;
		int number = 12;

		int expect = 4;
		int actual = solution.solution(N, number);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int N = 2;
		int number = 11;

		int expect = 3;
		int actual = solution.solution(N, number);
		assertThat(actual).isEqualTo(expect);
	}
}
