package test.exam.woo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class exam01 {
	/**
	 * 입력받은 문자열 배열에서 문자열을 대문자로 바꾸고 길이가 5이상 10이하인 첫번째 문자열을 반환
	 * 입력받은 문자열 배열에 조건에 맞는 대상이 없으면 "없음"을 반환
	 *
	 */
	class Solution {
		public String solution(String[] params) {
			return Arrays.stream(params)
				  .filter(s -> s.length() >= 5 && s.length() <= 10)
				  .map(String::toUpperCase)
				  .findFirst()
				  .orElse("없음");
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test() {
		String[] players = {"mumu", "soe", "dhlee", "kai", "mine"};

		String expect = "DHLEE";
		String actual = solution.solution(players);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test2() {
		String[] players = {"mumu", "soe", "koo", "kai", "mine"};

		String expect = "없음";
		String actual = solution.solution(players);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test3() {
		String[] players = {"mumu", "soe", "koo", "kai", "dhlee"};

		String expect = "DHLEE";
		String actual = solution.solution(players);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test4() {
		String[] players = {"mumu", "soe", "dhlee2", "kai", "dhlee"};

		String expect = "DHLEE2";
		String actual = solution.solution(players);

		assertThat(actual).isEqualTo(expect);
	}
}
