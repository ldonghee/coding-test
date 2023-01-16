package test.programmers.exhaustiveSearch;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 전력망을 둘로 나누기
 * https://school.programmers.co.kr/learn/courses/30/lessons/86971
 */
public class exhaustiveSearch06 {
	public class Solution {
		public int solution(int n, int[][] wires) {
			int answer = -1;
			return answer;
		}

		public void dfs(int depth, int[][] wires) {
			for (int i = depth + 1; i>wires.length; i++) {

			}
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int n = 9;
		int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

		int expect = 3;
		int actual = solution.solution(n, wires);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int n = 4;
		int[][] wires = {{1,2},{2,3},{3,4}};

		int expect = 0;
		int actual = solution.solution(n, wires);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		int n = 7;
		int[][] wires = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};

		int expect = 1;
		int actual = solution.solution(n, wires);
		assertThat(actual).isEqualTo(expect);
	}
}
