package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/description/
 */
public class ReverseString {
	public char[] reverseString(char[] s) {
		return null;
	}

	@Test
	void test1() {
		char[] s = {'h','e','l','l','o'};
		char[] expect = {'o','l','l','e','h'};
		char[] actual = reverseString(s);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	void test2() {
		char[] s = {'H','a','n','n','a','h'};
		char[] expect = {'h','a','n','n','a','H'};
		char[] actual = reverseString(s);
		assertThat(expect).isEqualTo(actual);
	}
}
