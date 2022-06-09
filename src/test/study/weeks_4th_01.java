package test.study;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * H-INDEX
 * https://leetcode.com/problems/h-index/
 * H-INDEX : 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index
 */
public class weeks_4th_01 {
    class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);

            for (int i=0; i<citations.length; i++) {
                // 논문 갯수
                int h = citations.length - i;

                // 해당 요소의 논문 인용 횟수 >= h 이상 인용된 논문 갯수
                if (citations[i] >= h) {
                    return h;
                }

            }

            return 0;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test1() {
        // given
        int[] citations = {3, 0, 6, 1, 5};
        int actual = 3;

        // when
        int expect = solution.hIndex(citations);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test2() {
        // given
        int[] citations = {1, 3, 1};
        int actual = 1;

        // when
        int expect = solution.hIndex(citations);

        // then
        assertThat(actual).isEqualTo(expect);
    }
}
