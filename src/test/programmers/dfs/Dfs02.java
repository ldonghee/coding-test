package test.programmers.dfs;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

/**
 * 게임 맵 최단거리
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */
public class Dfs02 {
    class Solution {
        ArrayList<Integer> answers = new ArrayList<>();

        public int solution(int[][] maps) {
            int answer = 0;
            // maps.length = 세로
            // maps[0].length = 가로

            boolean[][] visited = new boolean[maps.length][maps[0].length];
            visited[0][0] = true;

            dfs(1, maps, visited, new int[]{0, 0});

            return answers.size() == 0 ? -1 : answers.stream().min(Comparator.comparing(x -> x.intValue())).get() ;
        }

        public void dfs(int depth, int[][] maps, boolean[][] visited, int[] pos) {
            if (pos[1] + 1 < maps[0].length && !visited[pos[0]][pos[1] + 1] && maps[pos[0]][pos[1]] == 1) {
                // 0, +1
                visited[pos[0]][pos[1] + 1] = true;
                dfs(depth + 1, maps, visited, new int[]{pos[0], pos[1] + 1});
            }
            if (pos[0] + 1 < maps.length && !visited[pos[0] + 1][pos[1]] && maps[pos[0]][pos[1]] == 1) {
                // +1, 0
                visited[pos[0] + 1][pos[1]] = true;
                dfs(depth + 1, maps, visited, new int[]{pos[0] + 1, pos[1]});
            }
            if (pos[1] - 1 > 0 && !visited[pos[0]][pos[1] - 1] && maps[pos[0]][pos[1]] == 1) {
                // 0, -1
                visited[pos[0]][pos[1] - 1] = true;
                dfs(depth + 1, maps, visited, new int[]{pos[0], pos[1] - 1});
            }
            if (pos[0] - 1 > 0 && !visited[pos[0] - 1][pos[1]] && maps[pos[0]][pos[1]] == 1) {
                // -1, 0
                visited[pos[0] - 1][pos[1]] = true;
                dfs(depth + 1, maps, visited, new int[]{pos[0] - 1, pos[1]});
            }

            // pos y, x
            if (pos[0] == maps.length - 1 && pos[1] == maps[0].length - 1) {
                answers.add(depth);
                return;
            }
        }
    }

    private final Solution solution = new Solution();

    @Test
    public void test01() {
        int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};

        int expect = 11;
        int actual = solution.solution(maps);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test02() {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

        int expect = -1;
        int actual = solution.solution(maps);
        assertThat(actual).isEqualTo(expect);
    }
}
