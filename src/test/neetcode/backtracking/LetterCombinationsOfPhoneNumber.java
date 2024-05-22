package test.neetcode.backtracking;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfPhoneNumber {
	public List<String> letterCombinations(String digits) {
		return null;
	}

	@Test
	void test01() {
		String digits = "23";
		List<String> expect = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
		List<String> actual = letterCombinations(digits);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	void test02() {
		String digits = "";
		List<String> expect = Arrays.asList("");
		List<String> actual = letterCombinations(digits);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	void test03() {
		String digits = "2";
		List<String> expect = Arrays.asList("a", "b", "c");
		List<String> actual = letterCombinations(digits);
		assertThat(actual).isEqualTo(expect);
	}
}
