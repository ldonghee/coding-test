package test.neetcode.hashTable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 12. Integer to Roman
 * https://leetcode.com/problems/integer-to-roman/
 */
public class IntegerToRoman {
	public String intToRoman(int num) {
		return "";
	}

	@Test
	public void test01() {
		int num = 3749;
		String expect = "MMMDCCXLIX";
		String actual = intToRoman(num);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test02() {
		int num = 58;
		String expect = "LVIII";
		String actual = intToRoman(num);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test03() {
		int num = 1994;
		String expect = "MCMXCIV";
		String actual = intToRoman(num);
		assertThat(expect).isEqualTo(actual);
	}
}
