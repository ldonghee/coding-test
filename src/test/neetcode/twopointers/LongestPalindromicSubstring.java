package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		return "";
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
