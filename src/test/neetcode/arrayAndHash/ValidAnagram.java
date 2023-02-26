package test.neetcode.arrayAndHash;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 */

public class ValidAnagram {
	class Solution {
		public boolean isAnagram(String s, String t) {
			Map<Character, Integer> countMap = new HashMap<>();

			if (s.length() != t.length()) {
				return false;
			}

			for (int i=0; i<s.length(); i++) {
				char sc = s.charAt(i);
				char tc = t.charAt(i);
				countMap.put(sc, countMap.getOrDefault(sc, 0) + 1);
				countMap.put(tc, countMap.getOrDefault(tc, 0) - 1);
			}

			for (Character c : countMap.keySet()) {
				if (countMap.get(c) != 0) {
					return false;
				}
			}

			return true;
		}
	}


	private final Solution solution = new Solution();

	@Test
	public void test01() {
		String s = "anagram";
		String t = "nagaram";

		boolean expect = true;
		boolean actual = solution.isAnagram(s, t);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		String s = "rat";
		String t = "car";

		boolean expect = false;
		boolean actual = solution.isAnagram(s, t);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		String s = "a";
		String t = "ab";

		boolean expect = false;
		boolean actual = solution.isAnagram(s, t);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test04() {
		String s = "aa";
		String t = "bb";

		boolean expect = false;
		boolean actual = solution.isAnagram(s, t);
		assertThat(actual).isEqualTo(expect);
	}
}
