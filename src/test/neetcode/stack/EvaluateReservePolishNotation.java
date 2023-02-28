package test.neetcode.stack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * 150. Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReservePolishNotation {
	class Solution {

		public int evalRPN(String[] tokens) {
			Stack<Integer> stack = new Stack<>();

			for (int i=0; i<tokens.length; i++) {
				String token = tokens[i];
				if (token.equals("+")) {
					Integer right = stack.pop();
					Integer left = stack.pop();
					stack.push(left + right);
				} else if(token.equals("-")) {
					Integer right = stack.pop();
					Integer left = stack.pop();
					stack.push(left - right);
				} else if(token.equals("*")) {
					Integer right = stack.pop();
					Integer left = stack.pop();
					stack.push(left * right);
				} else if(token.equals("/")) {
					Integer right = stack.pop();
					Integer left = stack.pop();
					stack.push(left / right);
				} else {
					stack.push(Integer.parseInt(token));
				}
			}

			return stack.pop();
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		String[] tokens = {"2","1","+","3","*"};

		int expect = 9;
		int actual = solution.evalRPN(tokens);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		String[] tokens = {"4","13","5","/","+"};

		int expect = 6;
		int actual = solution.evalRPN(tokens);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

		int expect = 22;
		int actual = solution.evalRPN(tokens);
		assertThat(actual).isEqualTo(expect);
	}

}
