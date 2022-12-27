package test.programmers.stackQueue;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Test;

/**
 * 기능개발
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */
public class Stack03 {
	public class Solution {
		public int[] solution(int[] progresses, int[] speeds) {
			Queue<Integer> queue = new LinkedList<>();
			List<Integer> answers = new ArrayList<>();

			for (int i=0; i<progresses.length; i++) {
				int day = (100 - progresses[i]) / speeds[i];
				day = (100 - progresses[i]) % speeds[i] == 0 ? day : day + 1;
				queue.add(day);
			}

			Integer curDay = queue.poll();
			int count = 1;
			while (!queue.isEmpty()) {
				Integer nextDay = queue.poll();
				if (curDay >= nextDay) {
					count++;
				} else {
					answers.add(count);
					count = 1;
					curDay = nextDay;
				}
			}
			answers.add(count);

			return answers.stream().mapToInt(answer -> answer.intValue()).toArray();
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};

		int[] expect = {2, 1};
		int[] actual = solution.solution(progresses, speeds);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};

		int[] expect = {1, 3, 2};
		int[] actual = solution.solution(progresses, speeds);
		assertThat(actual).isEqualTo(expect);
	}
}
