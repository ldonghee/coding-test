package exam.todayhouse;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Test03 {
	class Solution {
		/*
		public int solution(int[] references) {
			Arrays.sort(references); // 오름차순 정렬
			int left = 0;
			int right = references.length - 1;
			int answer = 0;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (references[mid] >= references.length - mid) {
					// mid 이상 인용된 논문이 mid 개 이상인 경우
					answer = references.length - mid;
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			return answer;
		}
		*/
		public int solution(int[] references) {
			int max = 0;
			for (int i = 0; i < references.length; i++) {
				if (references[i] > max) {
					max = references[i];
				}
			}

			int[] count = new int[max + 1];
			for (int i = 0; i < references.length; i++) {
				count[references[i]]++;
			}

			int sum = 0;
			for (int i = count.length - 1; i >= 0; i--) {
				sum += count[i];
				if (sum >= i) {
					return i;
				}
			}

			return 0;
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[] references = {3, 0, 4, 2, 8};

		int expect = 3;
		int actual = solution.solution(references);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[] references = {3, 0, 6, 1, 5};

		int expect = 3;
		int actual = solution.solution(references);
		assertThat(actual).isEqualTo(expect);
	}
}
