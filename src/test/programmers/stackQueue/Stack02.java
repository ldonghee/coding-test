package test.programmers.stackQueue;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * 올바른 괄호
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
public class Stack02 {
	public class Solution {
		boolean solution(String s) {
			Stack<Character> stack = new Stack<>();

			for (int i=0; i<s.length(); i++) {
				if (!stack.isEmpty() && s.charAt(i) == ')') {
					stack.pop();
					continue;
				}
				stack.push(s.charAt(i));
			}

			return stack.isEmpty();
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		String s = "()()";

		boolean expect = true;
		boolean actual = solution.solution(s);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		String s = "(())()";

		boolean expect = true;
		boolean actual = solution.solution(s);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		String s = ")()(";

		boolean expect = false;
		boolean actual = solution.solution(s);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test04() {
		String s = "(()(";

		boolean expect = false;
		boolean actual = solution.solution(s);
		assertThat(actual).isEqualTo(expect);
	}
}
