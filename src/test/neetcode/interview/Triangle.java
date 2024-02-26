package test.neetcode.interview;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Triangle {
	/**
	 * 제약 제항
	 * 1 <= triangle.length <= 200
	 * triangle[0].length == 1
	 * triangle[i].length == triangle[i - 1].length + 1
	 * -104 <= triangle[i][j] <= 104
	 *
	 * 시간 복잡도 : O (N^2)
	 * 이 알고리즘에서는 삼각형의 모든 요소를 한 번씩 방문하므로 시간 복잡도는 O(N^2)입니다.
	 * 여기서 N은 삼각형의 높이를 나타냅니다.
	 *
	 * 공간 복잡도 : O(1)
	 * 이 알고리즘이 추가적인 공간을 사용하는 부분은 삼각형의 각 행에 대한 누적 합계를 저장하는 배열입니다.
	 * 이 배열의 크기는 삼각형의 높이에 비례하므로 공간 복잡도는 O(N) 입니다.
	 *
	 * 엣지 케이스
	 * 1. 삼각형의 높이가 1인 경우: 이 경우에는 선택할 수 있는 경로가 하나뿐이므로 그 값이 결과가 됩니다.
	 * 2. 삼각형의 모든 값이 음수인 경우: 이 경우에는 가장 큰 음수 값을 선택하는 것이 최적의 해결책이 됩니다.
	 * 3. 삼각형의 모든 값이 동일한 경우: 이 경우에는 어떤 경로를 선택하더라도 결과는 동일하게 됩니다.
	 * 4. 삼각형의 값 중 일부가 -104 또는 104와 같이 극단적인 값인 경우: 이 경우에도 알고리즘이 정확하게 작동해야 합니다.
	 *    이러한 극단적인 값이 최소 합계 경로에 포함되는지 여부는 그 값이 어디에 위치하고 주변 값이 어떤지에 따라 달라집니다.
	 *
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		int[] accSum = new int[triangle.size() + 1];

		// bottom up
		for (int i = triangle.size() - 1; i >= 0; i--) {
			List<Integer> step = triangle.get(i);

			for (int j = 0; j < step.size(); j++) {
				int min = Math.min(accSum[j], accSum[j + 1]);
				accSum[j] = min + step.get(j);
			}
		}

		return accSum[0];
	}

	@Test
	public void test01() {
		List<List<Integer>> triangle = Arrays.asList(Collections.singletonList(2),
													 Arrays.asList(3,4),
													 Arrays.asList(6,5,7),
													 Arrays.asList(4,1,8,3));
		int expect = 11;
		int actual = minimumTotal(triangle);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		List<List<Integer>> triangle = Arrays.asList(Collections.singletonList(-10));
		int expect = -10;
		int actual = minimumTotal(triangle);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		List<List<Integer>> triangle = Arrays.asList(Collections.singletonList(-1),
													 Arrays.asList(2,3),
													 Arrays.asList(1, -1, -3));
		int expect = -1;
		int actual = minimumTotal(triangle);
		assertThat(actual).isEqualTo(expect);
	}

}
