package test.neetcode.stack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		return false;
	}



	@Test
	void test1() {
		String s = "()";
		boolean expect = true;
		boolean actual = isValid(s);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	void test2() {
		String s = "()[]{}";
		boolean expect = true;
		boolean actual = isValid(s);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	void test3() {
		String s = "(]";
		boolean expect = false;
		boolean actual = isValid(s);
		assertThat(expect).isEqualTo(actual);
	}
}
