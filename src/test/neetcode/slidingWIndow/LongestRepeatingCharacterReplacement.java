package test.neetcode.slidingWIndow;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 424. Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * https://neetcode.io/roadmap
 */
public class LongestRepeatingCharacterReplacement {
	class Solution {

		public int characterReplacement(String s, int k) {
			int[] arr = new int[128];

			int left = 0;
			int right = 0;
			int max = 0;
			int result = 0;

			while(right < s.length()) {
				max = Math.max(max, ++arr[s.charAt(right)]);

				if (right - left + 1 - max > k) {
					arr[s.charAt(left)]--;
					left++;
				}

				result = Math.max(result, right - left + 1);
				right++;
			}

			return result;
		}
	}

	private final Solution solution = new Solution();


	@Test
	public void test01() {
		String s = "ABAB";
		int k = 2;

		int expect = 4;
		int actual = solution.characterReplacement(s, k);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		String s = "AABABBA";
		int k = 1;

		int expect = 4;
		int actual = solution.characterReplacement(s, k);
		assertThat(actual).isEqualTo(expect);
	}
}
