package test.programmers.greedy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * 큰 수 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/42883
 */
public class Greedy03 {
    class Solution {
        public String solution(String number, int k) {
            char[] answers = new char[number.length() - k];
            Stack<Character> stack = new Stack<>();

            for (int i=0; i<number.length(); i++) {
                char c = number.charAt(i);

                while(!stack.isEmpty() && stack.peek() < c && k>0) {
                    stack.pop();
                    k--;
                }
                stack.push(c);
            }

            for(int i=0; i<answers.length; i++)
                answers[i] = stack.get(i);

            return new String(answers);
        }
    }

    private final Solution solution = new Solution();

    @Test
    public void test01() {
        String number = "1924";
        int k = 2;

        String expect = "94";
        String actual = solution.solution(number, k);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test02() {
        String number = "1231234";
        int k = 3;

        String expect = "3234";
        String actual = solution.solution(number, k);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test03() {
        String number = "4177252841";
        int k = 4;

        String expect = "775841";
        String actual = solution.solution(number, k);
        assertThat(actual).isEqualTo(expect);
    }
}
