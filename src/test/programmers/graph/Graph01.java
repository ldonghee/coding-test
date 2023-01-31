package test.programmers.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 가장 먼 노드
 * https://school.programmers.co.kr/learn/courses/30/lessons/49189
 */
public class Graph01 {
	class Solution {
		public int solution(int n, int[][] edge) {
			int answer = 0;
			return answer;
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

		int expect = 3;
		int actual = solution.solution(n, edge);
		assertThat(actual).isEqualTo(expect);
	}
}
