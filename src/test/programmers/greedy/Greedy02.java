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

        List<Integer> answers = new ArrayList<>();

        public int solution2(String name) {
            int answer = 0;

            boolean[] visited = new boolean[name.length()];
            dfs(0, 0, 0, name, visited, false);

            answer = answers.stream().min(Comparator.comparing(x -> x)).get();
            return answer - 1;
        }

        public void dfs(int depth, int index, int count, String name, boolean[] visited, boolean isRight) {
            // 왼쪽 오른쪽
            if (isAllVisited(visited)) {
                answers.add(count);
            }

            if (index < 0 || index > name.length()) {
                return;
            }

            visited[index] = true;

            if (name.charAt(index) != 'A') {
                // move
                count += 1;
                // up/down
                count += Math.min(name.charAt(index) - 65, 26 - (name.charAt(index) - 65));
            }


            // 오른쪽 방향
            if (isRight) {
                dfs(depth + 1, index + 1, count, name, visited, true);
            }
            // 왼쪽 방향
            if (!isRight){
                dfs(depth + 1, name.length() - (depth + 1), count, name, visited, false);
            }
        }

        public boolean isAllVisited(boolean[] visited) {
            int count = 0;
            for (boolean v : visited)
                count += v ? 1 : 0;
            return count == visited.length;
        }
    }

    private final Solution solution = new Solution();

    @Test
    public void test01() {
        String name = "JEROEN";

        int expect = 56;
        int actual = solution.solution2(name);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test02() {
        String name = "JAN";

        int expect = 23;
        int actual = solution.solution2(name);
        assertThat(actual).isEqualTo(expect);
    }
}
