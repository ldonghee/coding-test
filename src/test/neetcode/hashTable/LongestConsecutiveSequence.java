package test.neetcode.hashTable;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		Arrays.sort(nums);

		int result = 0;
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int num : nums) {
			int count = countMap.getOrDefault(num - 1, 0) + 1;
			countMap.put(num, count);
			if (count > result) {
				result = count;
			}
		}

		return result;
	}


	public int bestLongestConsecutive(int[] nums) {
		int maxSeq = 0;
		Set<Integer> sequences = new HashSet();
		for (int num : nums) {
			sequences.add(num);
		}
		for (int num : nums) {
			int nextInSeq = num + 1;
			int prevInSeq = num - 1;
			int currentSequence = 1;
			while (sequences.remove(prevInSeq--)) {
				currentSequence++;
			}
			while (sequences.remove(nextInSeq++)) {
				currentSequence++;
			}
			if (currentSequence > maxSeq) {
				maxSeq = currentSequence;
			}
		}
		return maxSeq;
	}

	@Test
	public void test() {
		int[] nums = {100, 4, 200, 1, 3, 2};
		int expect = 4;
		int actual = bestLongestConsecutive(nums);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test2() {
		int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
		int expect = 9;
		int actual = bestLongestConsecutive(nums);
		assertThat(actual).isEqualTo(expect);
	}
}
