package exam.todayhouse;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Test05 {
	class Solution {

		public int solution(int[] heights1, int[] heights2) {
			int count = 0;
			int n = heights1.length;

			// 두 배열을 키순으로 정렬한다.
			Arrays.sort(heights1);
			Arrays.sort(heights2);

			// 높이가 낮은 학생과 높은 학생을 교환한다.
			for (int i = 0; i < n; i++) {
				if (heights1[i] < heights2[i]) {
					continue;
				}
				int temp = heights1[i];
				heights1[i] = heights2[i];
				heights2[i] = temp;
				count++;
			}
			return count;
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[] heights1 = {150, 170, 180, 180};
		int[] heights2 = {150, 160, 170, 190};

		int expect = 1;
		int actual = solution.solution(heights1, heights2);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[] heights1 = {130, 140};
		int[] heights2 = {130, 140};

		int expect = 0;
		int actual = solution.solution(heights1, heights2);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		int[] heights1 = {150, 180, 180, 180};
		int[] heights2 = {130, 160, 190, 200};

		int expect = 2;
		int actual = solution.solution(heights1, heights2);
		assertThat(actual).isEqualTo(expect);
	}
}
