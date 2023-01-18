package test.programmers.dynamicProgramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 정수 삼각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 */
public class Dp02 {

	class Solution2 {

		int max = 0;
		public int solution(int[][] triangle) {
			int answer = 0;

			dfs(0, triangle, 0, 0);

			return max;
		}

		public void dfs(int depth, int[][] triangle, int sum, int index) {
			sum += triangle[depth][index];

			if (depth == triangle.length - 1) {
				max = Math.max(max, sum);
				return;
			}

			for (int i=index; i<triangle.length; i++) {
				if (i > index + 1) {
					break;
				}
				dfs(depth + 1, triangle, sum, i);
			}
		}
	}

	class Solution {


		/**
		 *    7
		 *    3, 8
		 *    8, 1, 8
		 *    2, 7, 4, 4
		 *    4, 5, 2, 6, 5
		 *
		 *          7
		 *        3   8
		 *      8   1   8
		 *    2   7   4   4
		 *  4   5   2   6   5
		 */

		public int solution(int[][] triangle) {
			int answer = 0;

			int[][] temp = new int[triangle.length][triangle[triangle.length - 1].length];
			temp[0][0] = triangle[0][0];

			for (int i=1; i<triangle.length; i++) {
				temp[i][0] = temp[i - 1][0] + triangle[i][0];
				temp[i][i] = temp[i - 1][i - 1] + triangle[i][i];

				for (int j=1; j<=i-1; j++) {
					temp[i][j] = Math.max(temp[i - 1][j - 1], temp[i - 1][j]) + triangle[i][j];

					answer = Math.max(answer, temp[i][j]);
				}
 			}

			return answer;
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

		int expect = 30;
		int actual = solution.solution(triangle);
		assertThat(actual).isEqualTo(expect);
	}
}
