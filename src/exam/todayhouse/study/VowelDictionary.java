package exam.todayhouse.study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */
public class VowelDictionary {

	/**
	 * 사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다.
	 * 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.
	 * 단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.
	 */
	class Solution {
		private String[] arr = new String[]{"A", "E", "I", "O", "U"};
		private List<String> list = new ArrayList<>();

		public int solution(String word) {
			int answer = 0;

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
			System.out.println("str : " + str + ", depth : " + depth);
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
