package test.neetcode.backtracking;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfPhoneNumber {
	Map<String, String> digitMap = new HashMap<String, String>() {{
		put("2", "abc");
		put("3", "def");
		put("4", "ghi");
		put("5", "jkl");
		put("6", "mno");
		put("7", "pqrs");
		put("8", "tuv");
		put("9", "wxyz");
	}};
	List<String> answers = new ArrayList<>();

	public List<String> letterCombinations(String digits) {
		// 2 abc 3 def 4 ghi
		// 5 jkl 6 mno 7 pqrs
		// 8 tuv 9 wxyz
		// digits.length <= 4

		if (digits.length() < 1) {
			return answers;
		}

		String[] split = digits.split("");
		dfs(0, split, new LinkedList<String>());

		return answers;
	}

	public void dfs(int depth, String[] split, List<String> combinations) {
		if (depth == split.length) {
			String result = "";
			for (String s : combinations) {
				result += s;
			}
			answers.add(result);
			return;
		}

		String digitStr = digitMap.get(split[depth]);
		String[] digits = digitStr.split("");

		for (int i=0;i <digits.length; i++) {
			combinations.add(digits[i]);
			dfs(depth+1, split, combinations);
			combinations.remove(combinations.size() - 1);
		}
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
		List<String> expect = Arrays.asList(new String[]{});
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
