package test.neetcode.interview;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class GenerateParentheses_2 {
	/**
	 * 제약 사항
	 * 1 <= n <= 8
	 *
	 *
	 * 시간 복잡도: O(4^n / sqrt(n))
	 * 이 코드는 재귀적으로 가능한 모든 괄호 문자열을 생성하고, 이 중 유효한 것들만을 선택합니다.
	 * 모든 경우의 수를 생성하는 데 필요한 시간 복잡도는 O(2^(2n))이고, 이는 O(4^n)으로 표현될 수 있습니다.
	 * 그러나, 유효한 괄호 문자열을 선택하는 과정에서는 카탈란 수에 따라 약 sqrt(n)으로 나누어집니다.
	 * 따라서 최종적으로 시간 복잡도는 O(4^n / sqrt(n))입니다. => log n 유효한 괄호 문자열을 선택하는 일은 O(n‾√)
	 *
	 *
	 * 공간 복잡도: O(n)
	 * 이 코드는 괄호 문자열을 생성하고 저장하는 데 필요한 공간을 사용합니다.
	 * 괄호 문자열의 길이는 2n이며, 이를 저장하기 위한 공간이 필요합니다.
	 * 또한, 재귀 호출을 위한 스택 공간이 추가로 필요하며, 이는 입력 크기 n에 비례합니다. 따라서, 공간 복잡도는 O(n)입니다.
	 *
	 *
	 * 엣지 케이스
	 * 1. 최소 입력값
	 * n의 값이 1인 경우. 이 경우에는 가능한 괄호 문자열의 조합이 '(' 와 ')' 두 개만 존재하므로, 반환되는 문자열 리스트는 '()' 하나만을 포함해야 합니다.
	 *
	 * 2. 최대 입력값
	 * n의 값이 8인 경우. 이 경우에는 가능한 괄호 문자열 조합이 매우 많아집니다. 이 때문에 계산 시간과 메모리 사용량이 크게 증가할 것입니다.
	 *
	 * 3. 특정 패턴:
	 * 일부 괄호 문자열 조합은 특정 패턴을 가질 수 있습니다.
	 * 예를 들어, '()'는 모든 괄호 문자열 조합에 포함되는 기본적인 패턴입니다.
	 * 또한, '((()))', '(()())', '(())()' 등과 같은 패턴도 흔히 발생합니다.
	 * 이러한 패턴은 괄호 문자열 조합을 생성하는 방식에 따라 다르게 나타날 수 있습니다.
	 */
	public List<String> generateParenthesis(int n) {
		List<String> allAnswers = new ArrayList<>();
		StringBuilder builder = new StringBuilder();

		recursive(allAnswers, builder, "(", n-1, n);

		return allAnswers;
	}

	public void recursive(List<String> answers, StringBuilder builder, String parenthesis, int open, int close) {
		builder.append(parenthesis);

		if (open == 0 && close == 0) {
			answers.add(builder.toString());
			return;
		}

		if (open > 0) {
			recursive(answers, builder, "(", open-1, close);
			builder.delete(builder.length()-1, builder.length());
		}
		if (open < close) {
			recursive(answers, builder, ")", open, close-1);
			builder.delete(builder.length()-1, builder.length());
		}
	}



	@Test
	public void test01() {
		int n = 3;
		List<String> expect = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
		List<String> actual = generateParenthesis(n);

		assertAll(
				() -> assertThat(expect.size()).isEqualTo(actual.size()),
				() -> assertThat(expect.containsAll(actual)),
				() -> assertThat(actual.containsAll(expect)));
	}

	@Test
	public void test02() {
		int n = 1;
		List<String> expect = Arrays.asList("())");
		List<String> actual = generateParenthesis(n);

		assertAll(
				() -> assertThat(expect.size()).isEqualTo(actual.size()),
				() -> assertThat(expect.containsAll(actual)),
				() -> assertThat(actual.containsAll(expect)));
	}
}
