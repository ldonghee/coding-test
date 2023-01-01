package test.programmers.exhaustiveSearch;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 카펫
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */
public class exhaustiveSearch04 {
	class Solution {
		/**
		 * 넓이 = 노란색 + 갈색
		 * 넓이 = 가로 * 세로
		 *
		 * 가운데 노란색, 테두리 갈색
		 * 노란색 = (가로 - 2) * (세로 -2)
		 * 세로 = 넓이/가로
		 * 갈색 = 노란색 - 넓이
		 */
		public int[] solution(int brown, int yellow) {
			int[] answer = {};
			// 넓이
			int area = brown + yellow;

			for (int width=3; width<area/2; width++) {
				int y = (width - 2) * (area/width - 2);
				int b = area - y;

				int height = area/width;

				if (y == yellow && b == brown && width * height == area && width >= height) {
					answer = new int[]{width, height};
					break;
				}
			}

			return answer;
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int brown = 10;
		int yellow = 2;

		int[] expect = {4, 3};
		int[] actual = solution.solution(brown, yellow);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int brown = 8;
		int yellow = 1;

		int[] expect = {3, 3};
		int[] actual = solution.solution(brown, yellow);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		int brown = 24;
		int yellow = 24;

		int[] expect = {8, 6};
		int[] actual = solution.solution(brown, yellow);
		assertThat(actual).isEqualTo(expect);
	}
}
