package test.neetcode.interview;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class GenerateParentheses {
	/**
	 * 제약 사항
	 * 1 <= n <= 8
	 *
	 *
	 * 시간 복잡도: O(4^n / sqrt(n))
	 * 이 함수는 문제 해결 방식에 따라 모든 가능한 괄호 문자열 조합을 생성하는 데 시간이 소요됩니다.
	 * 이때, 전체적인 경우의 수를 생성하는 데 필요한 시간 복잡도는 대략적으로 O(2^(2n))이며, 이를 좀 더 간략하게 표현하면(4^n)으로 나타낼 수 있습니다.
	 * 하지만 이 모든 경우 수 중에서 유효한 괄호 문자열만을 선별하는 과정에서는 특 수학적 원리인 카탈란 수(Catalan numbers)가 적용되어, 전체 경우의 수를 약 sqrt(n)으로 나누어주는 역할을 합니다.
	 * 따라서 이를 종합하면, 최종적인 시간 복잡도는 O(4^n / sqrt(n))로 나타낼 수 있습니다.
	 *
	 * 공간 복잡도: O(n)
	 * 이 함수는 괄호 문자열을 생성하고 그것을 저장하는 데 필요한 메모리 공간이 필요합니다.
	 * 만들어진 괄호 문자열의 길이는 대략 2n입니다.
	 * 이 문자열을 저장하기 위해 필요한 메모리 공간이 공간 복잡도에 기여합니다.
	 * 더불어, 재귀 호출을 사용하는 경우, 호출 스택에 필요한 공간이 추가로 요구되며, 이 공간은 입력 크기 n에 비례하게 됩니다.
	 * 그러므로, 이 두 가지 요소를 종합하면 최종적인 공간 복잡도는 O(n)이라고 할 수 있습니다.
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

		// 모든 조합 구하기
		recursive(allAnswers, n*2, 1, "(", builder);

		return allAnswers;
	}

	public void recursive(List<String> answers, int size, int depth, String parenthesis, StringBuilder builder) {
		builder.append(parenthesis);

		if (depth == size) {
			// 쌍 괄호 체크
			if (isParenthesis(builder.toString())) {
				answers.add(builder.toString());
			}
			return;
		}
		recursive(answers, size, depth+1, "(", builder);
		builder.delete(builder.length()-1, builder.length());
		recursive(answers, size, depth+1, ")", builder);
		builder.delete(builder.length()-1, builder.length());
	}

	public boolean isParenthesis(String str) {
		String[] list = str.split("");
		Stack<String> stack = new Stack<>();
		for (String s : list) {
			if ("(".equals(s)) {
				stack.push(s);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}



	@Test
	public void test01() {
		int nums = 3;
		List<String> expect = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
		List<String> actual = generateParenthesis(nums);

		assertAll(
				() -> assertThat(expect.size()).isEqualTo(actual.size()),
				() -> assertThat(expect.containsAll(actual)),
				() -> assertThat(actual.containsAll(expect)));
	}

	@Test
	public void test02() {
		int nums = 1;
		List<String> expect = Arrays.asList("())");
		List<String> actual = generateParenthesis(nums);

		assertAll(
				() -> assertThat(expect.size()).isEqualTo(actual.size()),
				() -> assertThat(expect.containsAll(actual)),
				() -> assertThat(actual.containsAll(expect)));
	}
}
