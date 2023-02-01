package test.programmers.graph;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Test;

/**
 * 가장 먼 노드
 * https://school.programmers.co.kr/learn/courses/30/lessons/49189
 */
public class Graph01 {
	class Solution {
		public List<Integer>[] list;

		public int solution(int n, int[][] edge) {
			int answer = 0;

			list = new List[n + 1];
			for (int i = 1; i <= n; i++) {
				list[i] = new ArrayList<>();
			}

			for (int[] wire : edge) {
				list[wire[0]].add(wire[1]);
				list[wire[1]].add(wire[0]);
			}

			for (int i=2; i<=n; i++) {
				bfs(i);
			}

			return answer;
		}

		public int bfs(int target) {
			Queue<Integer> queue = new LinkedList<>();
			List<Integer> answers = new ArrayList<>();

			queue.add(1);
			int cnt = 0;

			while (!queue.isEmpty()) {
				int cur = queue.poll();
				cnt++;

				for (int next : list[cur]) {
					if (next != target) {
						queue.add(next);
					}

					if (next == target) {
						answers.add(cnt);
						break;
					}
				}
			}

			return cnt;
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
