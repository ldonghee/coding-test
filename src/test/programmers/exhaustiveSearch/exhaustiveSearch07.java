package test.programmers.exhaustiveSearch;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 모음사전
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */
public class exhaustiveSearch07 {
	public class Solution {
		private String[] arr;
		private List<String> list;

		public int solution(String word) {
			int answer = 0;
			list = new ArrayList<>();
			arr = new String[]{"A", "E", "I", "O", "U"};

			recursive(word, "", 0);

			for (int i=0; i<list.size(); i++) {
				if (list.get(i).equals(word)) {
					answer = i;
					break;
				}
			}

			return answer;
		}

		public void recursive(String word, String str, int depth) {
			list.add(str);

			if (depth == 5) {
				return;
			}

			for (int i=0; i<arr.length; i++) {
				recursive(word, str + arr[i], depth + 1);
			}
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		String word = "AAAAE";

		int expect = 6;
		int actual = solution.solution(word);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		String word = "AAAE";

		int expect = 10;
		int actual = solution.solution(word);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		String word = "I";

		int expect = 1563;
		int actual = solution.solution(word);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test04() {
		String word = "EIO";

		int expect = 1189;
		int actual = solution.solution(word);
		assertThat(actual).isEqualTo(expect);
	}
}
