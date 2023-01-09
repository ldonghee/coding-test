package test.programmers.dfs;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * 아이템 줍기
 * https://school.programmers.co.kr/learn/courses/30/lessons/87694
 */
public class Dfs04 {
    class Solution {
        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            int answer = 0;
            return answer;
        }
    }

    private final Solution solution = new Solution();

    @Test
    public void test01() {
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        int expect = 17;
        int actual = solution.solution(rectangle, characterX, characterY, itemX, itemY);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test2() {
        int[][] rectangle = {{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}};
        int characterX = 9;
        int characterY = 7;
        int itemX = 6;
        int itemY = 1;

        int expect = 11;
        int actual = solution.solution(rectangle, characterX, characterY, itemX, itemY);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test3() {
        int[][] rectangle = {{1,1,5,7}};
        int characterX = 1;
        int characterY = 1;
        int itemX = 4;
        int itemY = 7;

        int expect = 9;
        int actual = solution.solution(rectangle, characterX, characterY, itemX, itemY);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test4() {
        int[][] rectangle = {{2,1,7,5},{6,4,10,10}};
        int characterX = 3;
        int characterY = 1;
        int itemX = 7;
        int itemY = 10;

        int expect = 15;
        int actual = solution.solution(rectangle, characterX, characterY, itemX, itemY);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test5() {
        int[][] rectangle = {{2,2,5,5},{1,3,6,4},{3,1,4,6}};
        int characterX = 1;
        int characterY = 4;
        int itemX = 6;
        int itemY = 3;

        int expect = 10;
        int actual = solution.solution(rectangle, characterX, characterY, itemX, itemY);
        assertThat(actual).isEqualTo(expect);
    }
}
