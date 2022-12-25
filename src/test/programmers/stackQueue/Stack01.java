package test.programmers.stackQueue;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 같은 숫자는 싫어
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 */
public class Stack01 {
	public class Solution {
		public int[] solution(int []arr) {
			List<Integer> answer = new ArrayList<>();

			int before = arr[0];
			answer.add(before);

			for (int i=1; i<arr.length; i++) {
				if (before != arr[i]) {
					answer.add(arr[i]);
					before = arr[i];
				}
			}

			return answer.stream().mapToInt(item -> item.intValue()).toArray();
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[] arr = {1,1,3,3,0,1,1};

		int[] expect = {1,3,0,1};
		int[] actual = solution.solution(arr);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[] arr = {4,4,4,3,3};

		int[] expect = {4,3};
		int[] actual = solution.solution(arr);
		assertThat(actual).isEqualTo(expect);
	}
}
