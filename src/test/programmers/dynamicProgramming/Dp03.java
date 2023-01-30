package test.programmers.dynamicProgramming;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 등굣길
 * https://school.programmers.co.kr/learn/courses/30/lessons/42898
 */
public class Dp03 {

    class Solution {

        List<Integer> answers = new ArrayList<>();
        int shortestPath = 1000000007;

        public int solution(int m, int n, int[][] puddles) {
            List<int[]> puddleList = new ArrayList<>();
            for (int i=0; i<puddles.length; i++) {
                puddleList.add(puddles[i]);
            }

            dfs(0, m, n, puddleList, 0, 0);

            int answer = (int) answers.stream().filter(a -> a == shortestPath).count();

            return answer % 1000000007;
        }

        public void dfs(int depth, int m, int n, List<int[]> puddleList, int posX, int posY) {
            if (posX == m - 1 && posY == n - 1) {
                answers.add(depth);
                if (depth < shortestPath) {
                    shortestPath = depth;
                }
                return;
            }
            for (int i=0; i<puddleList.size(); i++) {
                int[] puddle = puddleList.get(i);
                if (puddle[0] == posX + 1 && puddle[1] == posY + 1) {
                    return;
                }
            }

            if (posX < m && posY < n) {
                dfs(depth + 1, m, n, puddleList, posX + 1, posY);
            }

            if (posY < n && posX < m) {
                dfs(depth + 1, m, n, puddleList, posX, posY + 1);
            }
        }
    }

    private final Solution solution = new Solution();

    @Test
    public void test01() {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        int expect = 4;
        int actual = solution.solution(m, n, puddles);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test02() {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}, {3, 2}};

        int expect = 2;
        int actual = solution.solution(m, n, puddles);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test03() {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 1}, {1, 3}, {2, 3}, {3, 3}};

        int expect = 1;
        int actual = solution.solution(m, n, puddles);
        assertThat(actual).isEqualTo(expect);
    }
}
