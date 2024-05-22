package test.neetcode.backtracking;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class GenerateParentheses {
	List<String> answers = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		dfs(0, 0, n, new LinkedList<>());
		return answers;
	}

	void dfs(int left, int right, int n, List<String> stack) {
		if (left == n && right == n) {
			String result = "";
			for (String s : stack) {
				result += s;
			}
			answers.add(result);
		}

		if (left < n) {
			stack.add("(");
			dfs(left+1, right, n, stack);
			stack.remove(stack.size() - 1);
		}

		if (right < left) {
			stack.add(")");
			dfs(left, right+1, n, stack);
			stack.remove(stack.size() - 1);
		}
	}

	@Test
	void test01() {
		int n = 3;
		List<String> expect = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
		List<String> actual = generateParenthesis(n);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int n = 1;
		List<String> expect = Arrays.asList("()");
		List<String> actual = generateParenthesis(n);
		assertThat(actual).isEqualTo(expect);
	}
}
