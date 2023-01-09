package test.programmers.dfs;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

/**
 * 게임 맵 최단거리
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */
public class Dfs02 {
    class Solution {
        ArrayList<Integer> answers = new ArrayList<>();

        public int solution(int[][] maps) {
            boolean[][] visited = new boolean[maps.length][maps[0].length];
            visited[0][0] = true;

            dfs(1, maps, visited, new int[]{0, 0});

            return answers.size() == 0 ? -1 : answers.stream().min(Comparator.comparing(x -> x.intValue())).get() ;
        }


        public void dfs(int depth, int[][] maps, boolean[][] visited, int[] pos) {
            if (pos[1] + 1 < maps[0].length && !visited[pos[0]][pos[1] + 1] && maps[pos[0]][pos[1] + 1] == 1) {
                // 0, +1
                visited[pos[0]][pos[1] + 1] = true;
                dfs(depth + 1, maps, visited, new int[]{pos[0], pos[1] + 1});
            }
            if (pos[0] + 1 < maps.length && !visited[pos[0] + 1][pos[1]] && maps[pos[0] + 1][pos[1]] == 1) {
                // +1, 0
                visited[pos[0] + 1][pos[1]] = true;
                dfs(depth + 1, maps, visited, new int[]{pos[0] + 1, pos[1]});
            }
            if (pos[1] - 1 >= 0 && !visited[pos[0]][pos[1] - 1] && maps[pos[0]][pos[1] - 1] == 1) {
                // 0, -1
                visited[pos[0]][pos[1] - 1] = true;
                dfs(depth + 1, maps, visited, new int[]{pos[0], pos[1] - 1});
            }
            if (pos[0] - 1 >= 0 && !visited[pos[0] - 1][pos[1]] && maps[pos[0] - 1][pos[1]] == 1) {
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

        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};

        public int solution2(int[][] maps) {
            int answer = 0;
            int[][] visited = new int[maps.length][maps[0].length];
            visited[0][0] = 1;

            dfsBest(maps, visited);

            answer = visited[maps.length - 1][maps[0].length - 1];

            if (answer == 0) {
                return -1;
            }

            return answer;
        }

        public void dfsBest(int[][] maps, int[][] visited) {
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{0, 0});

            while(!q.isEmpty()) {
                int[] now = q.poll();
                int x = now[0];
                int y = now[1];

                for (int i=0; i<4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                        visited[nx][ny] = visited[x][y] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    private final Solution solution = new Solution();

    @Test
    public void test01() {
        int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};

        int expect = 11;
        int actual = solution.solution2(maps);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test02() {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

        int expect = -1;
        int actual = solution.solution2(maps);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test03() {
        /**
         * 1 0 0
         * 1 0 0
         * 1 1 1
         */
        int[][] maps = {{1, 0, 0},{1, 1, 0},{0, 1, 1}};

        int expect = 5;
        int actual = solution.solution2(maps);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test04() {
        /**
         * 1
         */
        int[][] maps = {{1}};

        int expect = 1;
        int actual = solution.solution2(maps);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test05() {
        /**
         * 1 1 1 1 1
         * 0 0 0 0 1
         */
        int[][] maps = {{1, 1, 1, 1, 1}, {0, 0 ,0 ,0, 1}};

        int expect = 6;
        int actual = solution.solution2(maps);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test06() {
        /**
         * 1 0 1 1 1
         * 0 0 0 0 1
         */
        int[][] maps = {{1, 0, 1, 1, 1}, {0, 0 ,0 ,0, 1}};

        int expect = -1;
        int actual = solution.solution2(maps);
        assertThat(actual).isEqualTo(expect);
    }
}
