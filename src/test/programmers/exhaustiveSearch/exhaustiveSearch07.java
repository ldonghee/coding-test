package test.programmers.exhaustiveSearch;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 모음사전
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */
public class exhaustiveSearch07 {
	public class Solution {
		public int solution(String word) {
			int answer = 0;
			char[] vowel = {'A', 'E', 'I', 'O', 'U'};

			String fullWord = word;
			while (fullWord.length() < 5) {
				fullWord += "A";
			}

			char[] dic = {'A', 'A', 'A', 'A', 'A'};
			int count = 0;
			boolean flag = false;
			for (int i=4; i>=0; i--) {
				for (int j=0; j<5; j++) {
					count++;
					dic[i] = vowel[j];
					if (fullWord.equals(new String(dic))) {
						flag = true;
						break;
					}
				}
				dic[i] = 'A';
				if (flag) break;
			}



			return answer;
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
