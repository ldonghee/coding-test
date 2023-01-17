package test.programmers.exhaustiveSearch;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Test;

/**
 * 전력망을 둘로 나누기
 * https://school.programmers.co.kr/learn/courses/30/lessons/86971
 */
public class exhaustiveSearch06 {
	public class Solution {
		public List<Integer>[] list;

		public int solution(int n, int[][] wires) {
			int answer = 100;

			list = new List[n + 1];
			for (int i = 0; i <= n; i++) {
				list[i] = new ArrayList<>();
			}

			for (int[] wire : wires) {
				list[wire[0]].add(wire[1]);
				list[wire[1]].add(wire[0]);
			}

			for (int[] wire : wires) {
				int n1 = bfs(wire[0], wire[1], n);
				int n2 = bfs(wire[1], wire[0], n);

				answer = Math.min(answer, Math.abs(n1 - n2));
			}

			return answer;
		}

		public int bfs(int v1, int v2, int n) {
			Queue<Integer> queue = new LinkedList<>();
			boolean[] visit = new boolean[n + 1];

			int cnt = 0;

			queue.add(v1);
			visit[v1] = true;

			while (!queue.isEmpty()) {
				int cur = queue.poll();
				cnt++;

				for (int next : list[cur]) {
					if (next != v2 && !visit[next]) {
						queue.add(next);
						visit[next] = true;
					}
				}
			}

			return cnt;
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
