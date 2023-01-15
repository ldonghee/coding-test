package test.programmers.greedy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 조이스틱
 * https://school.programmers.co.kr/learn/courses/30/lessons/42860
 */
public class Greedy02 {
    class Solution {
        public int solution(String name) {
            int count = 0;
            int length = name.length();
            int index;
            int move = length -1; // 모든 커서를 한칸씩 이동해야함.
            for(int i=0; i<name.length(); i++){
                count += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

                index = i + 1;
                while(index < length && name.charAt(index) == 'A'){
                    index++;
                }
                move = Math.min(move, i * 2 + length - index);
                move = Math.min(move, (length - index) * 2 + i);
            }
            int answer = count + move;
            return answer;
        }
    }

    private final Solution solution = new Solution();

    @Test
    public void test01() {
        String name = "JEROEN";

        int expect = 56;
        int actual = solution.solution(name);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test02() {
        String name = "JAN";

        int expect = 23;
        int actual = solution.solution(name);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test03() {
        String name = "AAA";

        int expect = 0;
        int actual = solution.solution(name);
        assertThat(actual).isEqualTo(expect);
    }
}
