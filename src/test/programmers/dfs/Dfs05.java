package test.programmers.dfs;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 네트워크
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 */
public class Dfs05 {
	class Solution {

		public int solution(int n, int[][] computers) {
			int answer = 0;
			boolean[] visited = new boolean[n];

			for (int i=0; i<n; i++) {
				if (!visited[i]) {
					dfs(i, visited, computers);
					answer++;
				}
			}

			return answer;
		}

		public boolean[] dfs (int i, boolean[] visited, int[][] computers) {
			visited[i] = true;

			for (int j=0; j<computers[i].length; j++) {
				if (i != j && computers[i][j] == 1 && !visited[j]) {
					visited = dfs(j, visited, computers);
				}
			}
			return visited;
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

		int expect = 2;
		int actual = solution.solution(n, computers);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

		int expect = 1;
		int actual = solution.solution(n, computers);
		assertThat(actual).isEqualTo(expect);
	}
}
