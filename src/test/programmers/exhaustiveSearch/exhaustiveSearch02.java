package test.programmers.exhaustiveSearch;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * 모의고사
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 */
public class exhaustiveSearch02 {

    public class Solution {
        public int[] solution(int[] answers) {
            List<Integer> result = new ArrayList<>();

            int[] a = {1, 2, 3, 4, 5};
            int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            Map<Integer, Integer> counts = new HashMap<>();
            counts.put(1, 0);
            counts.put(2, 0);
            counts.put(3, 0);

            for (int i=0; i<answers.length; i++) {
                int answer = answers[i];

                if (answer == a[i % a.length]) counts.put(1, counts.get(1) + 1);
                if (answer == b[i % b.length]) counts.put(2, counts.get(2) + 1);
                if (answer == c[i % c.length]) counts.put(3, counts.get(3) + 1);
            }

            int max = 0;
            for (Integer key : counts.keySet()) {
                if (max < counts.get(key)) {
                    max = counts.get(key);
                }
            }

            for (Integer key : counts.keySet()) {
                if (max == counts.get(key)) {
                    result.add(key);
                }
            }

            return result.stream().mapToInt(item -> item.intValue()).toArray();
        }
    }

    private final Solution solution = new Solution();

    @Test
    public void test01() {
        int[] answers = {1,2,3,4,5};

        int[] expect = {1};
        int[] actual = solution.solution(answers);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test02() {
        int[] answers = {1,3,2,4,2};

        int[] expect = {1,2,3};
        int[] actual = solution.solution(answers);
        assertThat(actual).isEqualTo(expect);
    }
}
