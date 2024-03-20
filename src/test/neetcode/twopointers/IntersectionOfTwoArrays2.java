package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.junit.jupiter.api.Test;

public class IntersectionOfTwoArrays2 {
	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> countMap = new HashMap<>();
		List<Integer> answers = new ArrayList<>();

		for (int num : nums1) {
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);
		}

		for (int num : nums2) {
			if (countMap.containsKey(num)) {
				if (countMap.get(num) > 0) {
					countMap.put(num, countMap.get(num) - 1);
					answers.add(num);
				}
			}
		}

		return answers.stream().mapToInt(item -> item).toArray();
	}

	@Test
	void test1() {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		int[] expect = {2,2};
		int[] actual = intersect(nums1, nums2);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	void test2() {
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		int[] expect = {4,9};
		int[] actual = intersect(nums1, nums2);

		Arrays.sort(expect);
		Arrays.sort(actual);

		assertThat(expect).isEqualTo(actual);
	}
}
