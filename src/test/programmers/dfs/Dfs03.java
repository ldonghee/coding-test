package test.programmers.dfs;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * 단어 변환
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 */
public class Dfs03 {
    class Solution {
        boolean[] visited;
        Queue<Integer> answers = new PriorityQueue<>();

        public int solution(String begin, String target, String[] words) {
            Set<String> check = new HashSet<>();
            for (String word : words) {
                check.add(word);
            }

            if (!check.contains(target))
                return 0;

            visited = new boolean[words.length];
            dfs(begin, target, 0, words);

            return answers.poll();
        }

        public void dfs(String begin, String target, int depth, String[] words) {
            if (begin.equals(target)) {
                answers.add(depth);
            }


            for (int i=0; i<words.length; i++) {
                if (!visited[i] && getDiffCount(begin, words[i]) == 1) {
                    visited[i] = true;
                    dfs(words[i], target, depth + 1, words);
                    visited[i] = false;
                }
            }
        }

        public int getDiffCount(String word, String target) {
            int count = 0;
            for (int i=0; i<word.length(); i++) {
                if (word.charAt(i) != target.charAt(i)) {
                    count++;
                }

                if (count > 2) {
                    break;
                }
            }
            return count;
        }
    }

    private final Solution solution = new Solution();

    @Test
    public void test01() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        int expect = 4;
        int actual = solution.solution(begin, target, words);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test2() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        int expect = 0;
        int actual = solution.solution(begin, target, words);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test3() {
        String begin = "hit";
        String target = "hhh";
        String[] words = {"hhh", "hht"};

        int expect = 2;
        int actual = solution.solution(begin, target, words);
        assertThat(actual).isEqualTo(expect);
    }
}
