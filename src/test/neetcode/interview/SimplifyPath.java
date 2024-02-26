package test.neetcode.interview;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.jupiter.api.Test;

public class SimplifyPath {
	/**
	 * https://leetcode.com/problems/simplify-path/
	 *
	 *
	 */

	public int simplifyPath(String str) {
		Deque<Integer> stack = new ArrayDeque<>();
		int num = 0;
		char op = '+';
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isDigit(ch)) {
				num = num * 10 + (ch - '0');
			}
			if (!Character.isDigit(ch) || i == str.length() - 1) {
				if (op == '+') {
					stack.push(num);
				} else if (op == '-') {
					stack.push(-num);
				} else if (op == 'x') {
					stack.push(stack.pop() * num);
				}
				op = ch;
				num = 0;
			}
		}
		int total = 0;
		while (!stack.isEmpty()) {
			total += stack.pop();
		}
		return total;
	}

	@Test
	public void test01() {
//		String path = "2+3-5*5-5";
//		int expect = 3;
//		int actual = simplifyPath(path);
//
//		assertThat(expect).isEqualTo(actual);
		System.out.println('9' - '0');
		System.out.println('0' - '0');
	}
}
