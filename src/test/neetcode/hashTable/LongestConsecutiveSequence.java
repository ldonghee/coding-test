package test.neetcode.hashTable;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		return 0;
	}

	@Test
	public void test() {
		int[] nums = {100, 4, 200, 1, 3, 2};
		int expect = 4;
		int actual = longestConsecutive(nums);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test2() {
		int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
		int expect = 9;
		int actual = longestConsecutive(nums);
		assertThat(actual).isEqualTo(expect);
	}
}
