package test.programmers.heap;

import static org.assertj.core.api.Assertions.*;

import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Test;

/**
 * 더 맵게
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
public class Heap01 {
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;

            Queue<Integer> queue = new PriorityQueue<>();
            for (int scov : scoville) {
                queue.add(scov);
            }

            while (K > queue.peek()) {
                if (queue.size() == 1) {
                    return -1;
                }
                Integer first = queue.poll();
                Integer second = queue.poll();

                Integer mixed = first + (second * 2);
                queue.add(mixed);
                answer++;
            }
            return answer;
        }
    }

    private final Solution solution = new Solution();

    @Test
    public void test01() {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;

        int expect = 2;
        int actual = solution.solution(scoville, k);
        assertThat(actual).isEqualTo(expect);
    }
}
