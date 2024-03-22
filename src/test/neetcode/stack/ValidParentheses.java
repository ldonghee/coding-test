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
		Map<Character, Character> map = new HashMap<Character, Character>() {
			{
				put('{', '}');
				put('(', ')');
				put('[', ']');
				put('}', '{');
				put(']', '[');
				put(')', '(');
			}
		};
		Stack<Character> stack = new Stack<>();

		for (Character c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (stack.isEmpty() || stack.pop() != map.get(c)) {
				return false;
			}
		}

		return true;
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
