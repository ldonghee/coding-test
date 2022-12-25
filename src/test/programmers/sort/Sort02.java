package test.programmers.sort;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 가장 큰 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */
public class Sort02 {
	class Solution {
		public String solution(int[] numbers) {
			String answer = "";
			List<String> strNumbers = new ArrayList<>();
			for (int number : numbers) {
				strNumbers.add(String.valueOf(number));
			}

			Collections.sort(strNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

			 if ("0".equals(strNumbers.get(0))) {
			     return "0";
			 }

			for (String number : strNumbers) {
				answer += number;
			}
			return answer;
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[] numbers = {6, 10, 2};

		String expect = "6210";
		String actual = solution.solution(numbers);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[] numbers = {3, 30, 34, 5, 9};

		String expect = "9534330";
		String actual = solution.solution(numbers);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		int[] numbers = {0, 0, 0};

		String expect = "0";
		String actual = solution.solution(numbers);
		assertThat(actual).isEqualTo(expect);
	}
}
