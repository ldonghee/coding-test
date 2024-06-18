package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater2 {
	public int trap(int[] height) {
		int answer = 0;
		int maxIndex = 0;
		for (int i=0; i<height.length; i++) {
			if (height[i] > height[maxIndex]) {
				maxIndex = i;
			}
		}

		int left = 0;
		for (int i=0; i<maxIndex; i++) {
			if (height[left] < height[i]) {
				left = i;
			}
			if (height[left] > height[i]) {
				answer += height[left] - height[i];
			}
		}

		int right = height.length - 1;
		for (int i=height.length-1; i>maxIndex; i--) {
			if (height[right] < height[i]) {
				right = i;
			}
			if (height[right] > height[i]) {
				answer += height[right] - height[i];
			}
		}

		return answer;
	}

	@Test
	public void test01() {
		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int expect = 6;
		int actual = trap(height);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test02() {
		int[] height = {4, 2, 0, 3, 2, 5};
		int expect = 9;
		int actual = trap(height);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test03() {
		int[] height = {1,0,4,3,3,4,0,1};
		int expect = 4;
		int actual = trap(height);
		assertThat(expect).isEqualTo(actual);
	}
}
