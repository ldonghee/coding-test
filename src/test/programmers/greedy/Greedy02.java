package test.programmers.greedy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 조이스틱
 * https://school.programmers.co.kr/learn/courses/30/lessons/42860
 */
public class Greedy02 {
    class Solution {
        public int solution(String name) {
            int answer = 0;
            int LR = name.length() - 1; // 좌우 이동 최대 횟수

            for (int i=0; i<name.length(); i++) {
                // 위아래 조작 비교
                char c = name.charAt(i);
                // 아스키 코드 값 - 65(A)    A=0, Z=25
                // 위로 조작했을 때와 아래로 조작했을 때 작은 이동 값을 더하기
                answer += Math.min(c - 65, 26 - (c - 65));

                // 좌우 조작 비교
                // 다음 요소부터 연속된 A문자열 탐색
                int indexA = i + 1;
                while (indexA < name.length() && name.charAt(indexA) == 'A') {
                    indexA++;
                }

                // i+1 > 연속된 A문자열이 시작하기 전까지 갔다가 되돌아옴
                LR = Math.min(LR, i + i + name.length() - indexA);
            }


            return answer + LR;
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
}
