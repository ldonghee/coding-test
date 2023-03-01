package test.neetcode.stack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 * backtracking
 * 		- 모든 가능한 경우의 수 중에서 특정한 조건을 만족하는 경우만 살펴보는 것 입니다.
 * 		- 주로 문제 풀이에서는 재귀로 모든 경우의 수를 탐색하는 과정에서 답이 절대로 될 수 없는 상황을 정의하고
 * 		- 그 경우 탐색을 중지시킨 뒤 그 이전으로 돌아가서 다시 다른 경우를 탐색하도록 구현
 */
public class GenerateParentheses {
	class Solution {
		Stack<Character> stack = new Stack<>();
		List<String> res = new ArrayList<>();

		public List<String> generateParenthesis(int n) {
			backtrack(0, 0, n);
			return res;
		}

		private void backtrack(int openN, int closedN, int n) {
			if (openN == closedN && closedN == n) {
				Iterator vale = stack.iterator();
				String temp = "";
				while (vale.hasNext()) {
					temp = temp + vale.next();
				}
				res.add(temp);
			}
			if (openN < n) {
				stack.push('(');
				backtrack(openN + 1, closedN, n);
				stack.pop();
			}
			if (closedN < openN) {
				stack.push(')');
				backtrack(openN, closedN + 1, n);
				stack.pop();
			}
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int n = 3;

		List<String> expect = Arrays.asList("((()))","(()())","(())()","()(())","()()()");
		List<String> actual = solution.generateParenthesis(n);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int n = 1;

		List<String> expect = Arrays.asList("()");
		List<String> actual = solution.generateParenthesis(n);
		assertThat(actual).isEqualTo(expect);
	}
}
