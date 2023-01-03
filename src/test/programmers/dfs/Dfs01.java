package test.programmers.dfs;

import static org.assertj.core.api.Assertions.*;

import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Test;

/**
 * 타켓 넘버
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
public class Dfs01 {
    class Solution {
        public int solution(int[] numbers, int target) {
            int answer = dfs(0, numbers, target, 0);
            return answer;
        }

        public int dfs(int depth, int[] numbers, int target, int sum) {
            if (depth == numbers.length) {
                return sum == target ? 1 : 0;
            }
            return dfs(depth + 1, numbers, target, sum + numbers[depth]) + dfs(depth + 1, numbers, target, sum - numbers[depth]);
        }

    }

    private final Solution solution = new Solution();

    @Test
    public void test01() {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int expect = 5;
        int actual = solution.solution(numbers, target);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test02() {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;

        int expect = 2;
        int actual = solution.solution(numbers, target);
        assertThat(actual).isEqualTo(expect);
    }
}
