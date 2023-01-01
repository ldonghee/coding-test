package test.programmers.stackQueue;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

/**
 * 다리를 지나는 트럭
 * https://school.programmers.co.kr/learn/courses/30/lessons/42583
 */
public class Stack05 {
	public class Solution {
		public int solution(int bridge_length, int weight, int[] truck_weights) {
			int answer = 0;
			Queue<Integer> readyQueue = new LinkedList<>();
			Queue<Integer> bridgeQueue = new LinkedList<>();

			for (int truck_weight : truck_weights) {
				readyQueue.add(truck_weight);
			}
			for (int i = 0 ; i < bridge_length ; i++) {
				bridgeQueue.add(0);
			}

			int weightSum = 0;
			while (!bridgeQueue.isEmpty()) {
				weightSum -= bridgeQueue.poll();

				if (!readyQueue.isEmpty()) {
					if ((weightSum + readyQueue.peek()) <= weight) {
						bridgeQueue.add(readyQueue.peek());
						weightSum += readyQueue.peek();
						readyQueue.poll();
					} else {
						bridgeQueue.add(0);
					}
				} else {
					answer += bridge_length;
					break;
				}
				answer++;
			}

			return answer;
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};

		int expect = 8;
		int actual = solution.solution(bridge_length, weight, truck_weights);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10};

		int expect = 101;
		int actual = solution.solution(bridge_length, weight, truck_weights);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

		int expect = 110;
		int actual = solution.solution(bridge_length, weight, truck_weights);
		assertThat(actual).isEqualTo(expect);
	}
}
