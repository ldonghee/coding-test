package test.programmers.exhaustiveSearch;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 최소직사각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 */
public class exhaustiveSearch01 {

	/**
	 *
	 * Best
	public int solution(int[][] sizes) {
		int length = 0, height = 0;
		for (int[] card : sizes) {
			length = Math.max(length, Math.max(card[0], card[1]));
			height = Math.max(height, Math.min(card[0], card[1]));
		}
		int answer = length * height;
		return answer;
	}
	*/

	/**
	 * Best
	public int solution(int[][] sizes) {
		return Arrays.stream(sizes).reduce((a, b) -> new int[]{
				Math.max(Math.max(a[0], a[1]), Math.max(b[0], b[1])), Math.max(Math.min(a[0], a[1]), Math.min(b[0], b[1]))
		}).map(it -> it[0] * it[1]).get();
	}
	*/

	public class Solution {
		public int solution(int[][] sizes) {
			int bigSize = 0;
			int availableSize = 0;

			for (int i=0; i<sizes.length; i++) {
				int biggerSize = 0;
				for (int j=0; j<sizes[i].length; j++) {
					if (bigSize < sizes[i][j]) {
						bigSize = sizes[i][j];
					}
					if (biggerSize > sizes[i][j] || biggerSize == 0) {
						biggerSize = sizes[i][j];
					}
				}
				if (biggerSize > availableSize) {
					availableSize = biggerSize;
				}
			}

			return bigSize * availableSize;
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

		int expect = 4000;
		int actual = solution.solution(sizes);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};

		int expect = 120;
		int actual = solution.solution(sizes);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		int[][] sizes = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};

		int expect = 133;
		int actual = solution.solution(sizes);
		assertThat(actual).isEqualTo(expect);
	}
}
