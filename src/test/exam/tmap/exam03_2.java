package test.exam.tmap;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class exam03_2 {
	class Solution {
		public int solution(int[] A) {
			int n = A.length;
			int[] arr = new int[6];  // 각 숫자에 대한 가장 긴 연속된 도미노 타일 수를 저장

			// 도미노 타일을 순회하면서 각 숫자에 대한 가장 긴 연속된 도미노 타일 수를 계산
			for (int i = 0; i < n; i += 2) {
				int currentMax = arr[A[i + 1] - 1];  // 현재 도미노 타일의 오른쪽 숫자에 대한 연속된 도미노 타일 수
				int previousMax = arr[A[i] - 1] + 1;  // 현재 도미노 타일의 왼쪽 숫자에 대한 연속된 도미노 타일 수 (현재 도미노 타일을 포함하므로 +1)

				// 오른쪽 숫자에 대한 연속된 도미노 타일 수가 왼쪽 숫자에 대한 연속된 도미노 타일 수보다 작으면, 오른쪽 숫자에 대한 연속된 도미노 타일 수를 갱신
				if (currentMax < previousMax) {
					arr[A[i + 1] - 1] = previousMax;
				}
			}

			int maxVal = Arrays.stream(arr).max().getAsInt();  // 가장 긴 연속된 도미노 타일 수를 찾음
			return n / 2 - maxVal;  // 전체 도미노 타일 수에서 가장 긴 연속된 도미노 타일 수를 뺌 (제거해야 하는 도미노 타일 수)
		}
	}

	private final Solution solution = new Solution();


	@Test
	public void test1() {
		int[] A = {2, 4, 1, 3, 4, 6, 2, 4, 1, 6};

		int expect = 3;
		int actual = solution.solution(A);

		assertThat(actual).isEqualTo(expect);
	}


	@Test
	public void test2() {
		int[] A = {5, 1, 2, 6, 6, 1, 3, 1, 4, 3, 4, 3, 4, 6, 1, 2, 4, 1, 6, 2};

		int expect = 7;
		int actual = solution.solution(A);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test3() {
		int[] A = {1, 5, 3, 3, 1, 3};

		int expect = 2;
		int actual = solution.solution(A);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test4() {
		int[] A = {3, 4};

		int expect = 0;
		int actual = solution.solution(A);

		assertThat(actual).isEqualTo(expect);
	}
}