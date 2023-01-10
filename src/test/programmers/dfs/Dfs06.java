package test.programmers.dfs;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

/**
 * 여행경로
 * https://school.programmers.co.kr/learn/courses/30/lessons/43164
 */
public class Dfs06 {
    class Solution {
        ArrayList<String> list = new ArrayList<>();
        boolean visited[];

        public String[] solution(String[][] tickets) {
			visited = new boolean[tickets.length];

            dfs(0, "ICN", "ICN", tickets);

            Collections.sort(list);

            return list.get(0).split(" ");
        }

        void dfs(int depth, String target, String path, String[][] tickets){
            if (depth == tickets.length) {
                list.add(path);
                return;
            }

            for (int i=0; i < visited.length; i++) {
                if (!visited[i] && target.equals(tickets[i][0])) {
					visited[i] = true;
                    dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
					visited[i] = false;
                }
            }
        }
    }

    private final Solution solution = new Solution();

    @Test
    public void test01() {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        String[] expect = {"ICN", "JFK", "HND", "IAD"};
        String[] actual = solution.solution(tickets);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test02() {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        String[] expect = {"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"};
        String[] actual = solution.solution(tickets);
        assertThat(actual).isEqualTo(expect);
    }
}
