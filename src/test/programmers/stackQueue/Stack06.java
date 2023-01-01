package test.programmers.stackQueue;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Test;

/**
 * 주식가격
 * https://school.programmers.co.kr/learn/courses/30/lessons/42584
 */
public class Stack06 {
	public class Solution {
		public int[] solution(int[] prices) {
			Queue<Integer> queue = new LinkedList<>();
			List<Integer> answers = new ArrayList<>();
			for (int price : prices) {
				queue.add(price);
			}

			int index = 1;
			while (!queue.isEmpty()) {
				int price = queue.poll();
				int count = 0;
				for (int i=index; i<prices.length; i++) {
					count++;
					if (price > prices[i]) {
						break;
					}
				}
				answers.add(count);
				index++;
			}

			return answers.stream().mapToInt(answer -> answer.intValue()).toArray();
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[] prices = {1, 2, 3, 2, 3};

		int[] expect = {4, 3, 1, 1, 0};
		int[] actual = solution.solution(prices);
		assertThat(actual).isEqualTo(expect);
	}
}
