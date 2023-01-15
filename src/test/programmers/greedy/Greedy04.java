package test.programmers.greedy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/**
 * 구명보트
 * https://school.programmers.co.kr/learn/courses/30/lessons/42885
 */
public class Greedy04 {
    class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;

            List<Integer> peoples = Arrays.stream(people).boxed().collect(Collectors.toList());
            Collections.sort(peoples);

            int index = 0;
            for (int i=peoples.size() - 1; i>=index; i--) {
                if (peoples.get(i) + peoples.get(index) <= limit) {
                    index++;
                    answer++;
                } else {
                    answer++;
                }
            }

            return answer;
        }
    }

    private final Solution solution = new Solution();

    @Test
    public void test01() {
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        int expect = 3;
        int actual = solution.solution(people, limit);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test02() {
        int[] people = {70, 80, 50};
        int limit = 100;

        int expect = 3;
        int actual = solution.solution(people, limit);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test03() {
        int[] people = {50, 50};
        int limit = 100;

        int expect = 1;
        int actual = solution.solution(people, limit);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test04() {
        int[] people = {40, 40, 80};
        int limit = 160;

        int expect = 2;
        int actual = solution.solution(people, limit);
        assertThat(actual).isEqualTo(expect);
    }


    @Test
    public void test05() {
        int[] people = {40, 40, 80, 80};
        int limit = 160;

        int expect = 2;
        int actual = solution.solution(people, limit);
        assertThat(actual).isEqualTo(expect);
    }
}
