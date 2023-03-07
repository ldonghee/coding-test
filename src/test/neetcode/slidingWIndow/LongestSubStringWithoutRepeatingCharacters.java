package test.neetcode.slidingWIndow;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * https://neetcode.io/roadmap
 */
public class LongestSubStringWithoutRepeatingCharacters {
	class Solution {
		public int lengthOfLongestSubstring(String s) {
			List<Character> list = new ArrayList<>();
			int max = 0;

			for (int i=0; i<s.length(); i++) {
				if (list.contains(s.charAt(i))) {
					int index = list.indexOf(s.charAt(i));
					list.remove(index);
					if (index > 0)
						list.subList(0, index).clear();
				}

				list.add(s.charAt(i));
				max = Math.max(max, list.size());
			}


			return max;
		}
	}

	private final Solution solution = new Solution();


	@Test
	public void test01() {
		String s = "abcabcbb";

		int expect = 3;
		int actual = solution.lengthOfLongestSubstring(s);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		String s = "bbbbb";

		int expect = 1;
		int actual = solution.lengthOfLongestSubstring(s);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		String s = "pwwkew";

		int expect = 3;
		int actual = solution.lengthOfLongestSubstring(s);
		assertThat(actual).isEqualTo(expect);
	}
}
