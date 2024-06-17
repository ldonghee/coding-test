package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
	public int trap(int[] height) {
		if (height.length == 0) {
			return 0;
		}

		int trap = 0;
		int top = height[0];
		int index = 0;
		// Max Index 구하기
		for (int i = 0; i < height.length; i++) {
			if (top <= height[i]) {
				index = i;
				top = height[i];
			}
		}

		int left = height[0];
		for (int i = 0; i < index; i++) {
			if (height[i] > left) {
				left = height[i];
			} else if (height[i] < left) {
				trap += (left - height[i]);
			}
		}

		int right = height[height.length - 1];
		for (int i = height.length - 1; i > index; i--) {
			if (height[i] > right) {
				right = height[i];
			} else if (height[i] < right) {
				trap += (right - height[i]);
			}
		}

		return trap;
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
