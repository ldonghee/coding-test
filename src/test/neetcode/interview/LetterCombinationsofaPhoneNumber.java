package test.neetcode.interview;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class LetterCombinationsofaPhoneNumber {
	/**
	 * 재약 사항
	 * 0 <= digits.length <= 4
	 * digits[i] is a digit in the range ['2', '9']
	 *
	 *
	 * 시간 복잡도: O(4^N)
	 * 입력 문자열의 길이가 최대 4이며, 각 숫자에 대응되는 문자의 최대 개수가 4개라는 점을 고려했을 때,
	 * 가능한 모든 조합을 찾기 위해서는 4의 N 제곱번의 연산이 필요하기 때문입니다.
	 * 즉, 입력값에 따라 연산의 수가 지수적으로 증가하므로, 이를 표현하는 시간 복잡도는 O(4^N)이 됩니다.
	 *
	 * 공간 복잡도: O(N)
	 * 공간 복잡도는 주로 재귀 호출 스택의 깊이에 의해 결정됩니다.
	 * 재귀 호출 스택의 깊이는 입력 문자열의 길이에 비례하므로, 이 경우 공간 복잡도는 O(N)이 됩니다.
	 * 즉, 입력 문자열의 길이가 길어질수록 필요한 공간도 비례하여 증가하게 됩니다.
	 *
	 * 엣지 케이스
	 * 1. 빈 문자열: 입력 문자열이 비어 있는 경우는 어떻게 될까요?
	 * 이 경우 함수는 빈 리스트를 반환해야 합니다. 이는 코드에서 이미 처리되고 있습니다.
	 *
	 * 2. 한 가지 문자만 있는 경우: 예를 들어, 입력이 '2' 또는 '3'같이 한 가지 숫자만 있는 경우는 어떻게 될까요?
	 * 이 경우 함수는 해당 숫자에 대응하는 모든 문자를 포함하는 리스트를 반환해야 합니다.
	 *
	 * 3. 동일한 숫자가 반복되는 경우: 예를 들어, 입력이 '2222'나 '3333'과 같이 동일한 숫자가 반복되는 경우는 어떻게 될까요?
	 * 이 경우 함수는 해당 숫자에 대응하는 모든 문자의 조합을 반환해야 합니다.
	 *
	 * 4. '1'이 포함된 경우: '1'은 어떤 문자에도 대응되지 않으므로, '1'이 포함된 입력이 주어진 경우 함수는 어떻게 처리해야 할까요?
	 * 이 경우는 코드에서 특별히 처리되지 않았으므로, 이는 엣지 케이스로 간주할 수 있습니다.
	 */
	private Map<String, String> letters = new HashMap<String, String>(){{
		put("1", "");
		put("2", "abc");
		put("3", "def");
		put("4", "ghi");
		put("5", "jkl");
		put("6", "mno");
		put("7", "pqrs");
		put("8", "tuv");
		put("9", "wxyz");
	}};

	public List<String> letterCombinations(String digits) {
		List<String> answers = new ArrayList<>();
		StringBuilder builder = new StringBuilder();

		if (digits.length() < 1) {
			return answers;
		}

		dfs(answers, builder, 0, digits.toCharArray());

		return answers;
	}

	private void dfs(List<String> answers, StringBuilder builder, int depth, char[] digits) {
		if (depth == digits.length) {
			answers.add(builder.toString());
			return;
		}

		String digit = letters.get(String.valueOf(digits[depth]));

		for (int i=0; i<digit.length(); i++) {
			builder.append(digit.charAt(i));
			dfs(answers, builder, depth+1, digits);
			builder.delete(builder.length()-1, builder.length());
		}
	}

	@Test
	public void test01() {
		String digits = "23";
		List<String> expect = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
		List<String> actual = letterCombinations(digits);

		assertAll(
				() -> assertThat(expect.size()).isEqualTo(actual.size()),
				() -> assertThat(expect.containsAll(actual)),
				() -> assertThat(actual.containsAll(expect)));
	}

	@Test
	public void test02() {
		String digits = "";
		List<String> expect = Arrays.asList(new String[]{});
		List<String> actual = letterCombinations(digits);

		assertAll(
				() -> assertThat(expect.size()).isEqualTo(actual.size()),
				() -> assertThat(expect.containsAll(actual)),
				() -> assertThat(actual.containsAll(expect)));
	}

	@Test
	public void test03() {
		String digits = "2";
		List<String> expect = Arrays.asList("a", "b", "c");
		List<String> actual = letterCombinations(digits);

		assertAll(
				() -> assertThat(expect.size()).isEqualTo(actual.size()),
				() -> assertThat(expect.containsAll(actual)),
				() -> assertThat(actual.containsAll(expect)));
	}
}
