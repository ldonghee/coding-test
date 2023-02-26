package test.neetcode.arrayAndHash;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {
	class Solution {
		public boolean containsDuplicate(int[] nums) {
			HashSet<Integer> countSet = new HashSet<>();

			for (int num : nums) {
				if (countSet.contains(num)) {
					return true;
				}
				countSet.add(num);
			}

			return false;
		}
	}


	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[] num = {1,2,3,1};

		boolean expect = true;
		boolean actual = solution.containsDuplicate(num);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[] num = {1,2,3,4};

		boolean expect = false;
		boolean actual = solution.containsDuplicate(num);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		int[] num = {1,1,1,3,3,4,3,2,4,2};

		boolean expect = true;
		boolean actual = solution.containsDuplicate(num);
		assertThat(actual).isEqualTo(expect);
	}
}
