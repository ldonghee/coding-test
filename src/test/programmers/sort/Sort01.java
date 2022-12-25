package test.programmers.sort;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * k번째 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */
public class Sort01 {
	class Solution {
		public int[] solution(int[] array, int[][] commands) {
			List<Integer> result = new ArrayList<>();

			for (int i=0; i<commands.length; i++) {
				int[] indexes = commands[i];
				// List<Integer> subList = collect.subList(indexes[0] - 1, indexes[1]);

				List<Integer> subList = new ArrayList<>();
				for (int j=indexes[0]-1; j<indexes[1]; j++) {
					subList.add(array[j]);
				}
				Collections.sort(subList);
				result.add(subList.get(indexes[2] - 1));
			}

			return result.stream().mapToInt(Integer::intValue).toArray();
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

		int[] expect = {5,6,3};
		int[] actual = solution.solution(array, commands);
		assertThat(actual).isEqualTo(expect);
	}
}
