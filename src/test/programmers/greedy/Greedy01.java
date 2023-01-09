package test.programmers.greedy;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * 체육복
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 */
public class Greedy01 {
    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int[] students = new int[n];
            for (int i=0; i<n; i++) {
                students[i] = 1;
            }

            for (int l : lost) {
                students[l - 1] -= 1;
            }

            for (int r : reserve) {
                students[r - 1] += 1;
            }

            for (int i=0; i<n; i++) {
                if (students[i] == 0) {
                    if (i - 1 >= 0 && students[i - 1] > 1) {
                        students[i - 1] -= 1;
                        students[i] += 1;
                    } else if (i + 1 < n && students[i + 1] > 1) {
                        students[i + 1] -= 1;
                        students[i] += 1;
                    }
                }
            }

            return (int) Arrays.stream(students).filter(i -> i > 0).count();
        }
    }

    private final Solution solution = new Solution();

    @Test
    public void test01() {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1,4,5};

        int expect = 5;
        int actual = solution.solution(n, lost, reserve);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test02() {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {3};

        int expect = 4;
        int actual = solution.solution(n, lost, reserve);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test03() {
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};

        int expect = 2;
        int actual = solution.solution(n, lost, reserve);
        assertThat(actual).isEqualTo(expect);
    }
}
