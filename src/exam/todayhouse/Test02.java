package exam.todayhouse;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Test02 {
	class Solution {
		public String solution(String str) {
			String vowels = "";
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
					ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
					vowels += ch;
				}
			}
			String reversed = "";
			for (int i = vowels.length() - 1; i >= 0; i--) {
				reversed += vowels.charAt(i);
			}
			int index = 0;
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
					ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
					result.append(reversed.charAt(index));
					index++;
				} else {
					result.append(ch);
				}
			}
			return result.toString();
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		String str = "bucketplace";

		String expect = "beckatplecu";
		String actual = solution.solution(str);
		assertThat(actual).isEqualTo(expect);
	}
}
