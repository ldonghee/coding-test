package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 * https://neetcode.io/roadmap
 */
public class ContainerWithMostWater {
	class Solution {
		public int maxArea(int[] height) {
			int max = 0;
			int leftIndex = 0;
			int rightIndex = height.length - 1;

			while(leftIndex != rightIndex) {
				int leftValue = height[leftIndex];
				int rightValue = height[rightIndex];
				int tempValue;

				if (leftValue < rightValue) {
					tempValue = (rightIndex - leftIndex) * leftValue;
					leftIndex++;
				} else {
					tempValue = (rightIndex - leftIndex) * rightValue;
					rightIndex--;
				}

				if (max < tempValue) {
					max = tempValue;
				}
			}

			return max;
		}
	}


	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[] height = {1,8,6,2,5,4,8,3,7};

		int expect = 49;
		int actual = solution.maxArea(height);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[] height = {1,1};

		int expect = 1;
		int actual = solution.maxArea(height);
		assertThat(actual).isEqualTo(expect);
	}
}
