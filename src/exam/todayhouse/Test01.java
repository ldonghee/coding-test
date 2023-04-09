package exam.todayhouse;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class Test01 {
	class Solution {
		public int[] solution(int[] numbers, int goal) {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < numbers.length; i++) {
				int complement = goal - numbers[i];
				if (map.containsKey(complement)) {
					return new int[] { map.get(complement), i };
				}
				map.put(numbers[i], i);
			}
			return new int[0];
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[] numbers = {4, 3, 5, 1};
		int goal = 4;

		int[] expect = {1, 3};
		int[] actual = solution.solution(numbers, goal);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[] numbers = {3, 2, 4};
		int goal = 6;

		int[] expect = {1, 2};
		int[] actual = solution.solution(numbers, goal);
		assertThat(actual).isEqualTo(expect);
	}
}
