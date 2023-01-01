package test.programmers.exhaustiveSearch;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/**
 * 피로도
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
public class exhaustiveSearch05 {
	public class Solution {
		public int answer = -1;

		public int solution(int k, int[][] dungeons) {
			List<Progress> progressList = Arrays.stream(dungeons)
												.map(dungeon -> new Progress(dungeon))
												.collect(Collectors.toList());
			dfs(0, k, progressList);

			return answer;
		}

		private void dfs(int depth, int k, List<Progress> progressList) {
			for (Progress progress : progressList) {
				if (!progress.visited && progress.getTired() <= k) {
					progress.visited = true;
					dfs(depth + 1, k - progress.getConsume(), progressList);
					progress.visited = false;
				}
			}
			answer = Math.max(answer, depth);
		}

		public class Progress {
			int[] dungeon;
			boolean visited;

			public Progress(int[] dungeon) {
				this.dungeon = dungeon;
				this.visited = false;
			}

			public int getTired() {
				return dungeon[0];
			}

			public int getConsume() {
				return dungeon[1];
			}
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};

		int expect = 3;
		int actual = solution.solution(k, dungeons);
		assertThat(actual).isEqualTo(expect);
	}
}
