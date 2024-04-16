package test.neetcode.dynamicProgramming;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {
	/**
	 * 1 -> A
	 * 2 -> B
	 * 3 -> C
	 * ..
	 * ..
	 * 26 -> Z
	 */
	List<String> answers = new ArrayList<>();

	public int numDecodings(String s) {
		// 1 <= s.length <= 100

		// 숫자를 문자로 표현 방식?
		// 아스키코드 A => 65, Z => 90
		// A : 65 - 65 + 1 => 1
		// Z : 90 - 65 + 1 => 26

		// 문자열 s를 어떻게 나눌것인가?
		//
		// 2 2 6
		// 방문 관리 리스트 visited[s.length]
		//

//		dfs(s, 0, s.charAt(0), new StringBuilder());

		return 0;
	}

//	void dfs(String s, int index, char prev, StringBuilder builder) {
//		if (index == s.length()) {
////			String.valueOf((char)(s.charAt(0) + 17))
//
//			answers.add(builder.toString());
//			return;
//		}
//
//		if ((prev + ((int) s.charAt(index)) <= 26) {
//			int ch = ((int) prev) + ((int) s.charAt(index)) + 65;
//			String tempResult = String.valueOf(ch);
//			builder.append(tempResult);
//		}
//
//		dfs(s, index+1, s.charAt(index), builder);
//	}

	@Test
	public void test() {
		String s = "12";
		int expect = 2;
		int actual = numDecodings(s);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test2() {
		String s = "226";
		int expect = 3;
		int actual = numDecodings(s);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test3() {
		String s = "06";
		int expect = 0;
		int actual = numDecodings(s);
		assertThat(actual).isEqualTo(expect);
	}
}
