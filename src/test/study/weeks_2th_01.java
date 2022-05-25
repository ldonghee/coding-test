package test.study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;


/**
 * 튜플
 * https://programmers.co.kr/learn/courses/30/lessons/64065
 */
public class weeks_2th_01 {
    public class Solution {
        public int[] solution(String s) {
            String[] stringArray = s.substring(2, s.length() - 2).split("},\\{");
            Set<Integer> result = new LinkedHashSet<>();


            // inputMap
            // 3: 1,2,3
            // 2: 2,1
            // 4: 1,2,4,3
            // 1: 2
            Map<Integer, int[]> inputMap = new HashMap<>();
            for (String a : stringArray) {
                int[] temp = Stream.of(a.split(",")).mapToInt(Integer::parseInt).toArray();
                inputMap.put(temp.length, temp);
            }

            // key 값 1 부터 사이즈 만큼 순회
            for (int i=1; i<=inputMap.keySet().size(); i++) {
                int[] temp = inputMap.get(i);
                for (int t : temp) {
                    result.add(t);
                }
            }

            return result.stream().mapToInt(i->i).toArray();
        }
    }

    private Solution solution = new Solution();

    @Test
    public void test1() {
        String input = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int[] expect = {2, 1, 3, 4};
        int[] actual = solution.solution(input);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test2() {
        String input = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        int[] expect = {2, 1, 3, 4};
        int[] actual = solution.solution(input);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test3() {
        String input = "{{20,111},{111}}";
        int[] expect = {111, 20};
        int[] actual = solution.solution(input);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test4() {
        String input = "{{123}}";
        int[] expect = {123};
        int[] actual = solution.solution(input);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test5() {
        String input = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        int[] expect = {3, 2, 4, 1};
        int[] actual = solution.solution(input);
        assertThat(actual).isEqualTo(expect);
    }
}
