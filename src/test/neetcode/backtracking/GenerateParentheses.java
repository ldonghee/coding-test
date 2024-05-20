package test.neetcode.backtracking;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		return null;
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
