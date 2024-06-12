package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s.length() <= 1) {
			return s;
		}

		String answer = "";
		int left = 0;
		int right = s.length() - 1;

		while (left <= right) {
			String subStr = s.substring(left, right + 1);

			if (answer.length() >= subStr.length()) {
				left++;
				right = s.length() - 1;
				continue;
			}

			if (isPalindrome(subStr)) {
				answer = subStr;
				left++;
				right = s.length() - 1;
			} else {
				right--;
			}
		}

		return answer;
	}

	public boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	@Test
	public void test01() {
		String s = "babad";
		String expect = "bab";

		String actual = longestPalindrome(s);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test02() {
		String s = "cbbd";
		String expect = "bb";

		String actual = longestPalindrome(s);
		assertThat(expect).isEqualTo(actual);
	}
}
