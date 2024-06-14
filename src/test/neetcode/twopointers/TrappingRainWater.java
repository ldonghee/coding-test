package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
	public int trap(int[] height) {
		return 0;
	}

	@Test
	public void test01() {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		int expect = 6;
		int actual = trap(height);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test02() {
		int[] height = {4,2,0,3,2,5};
		int expect = 9;
		int actual = trap(height);
		assertThat(expect).isEqualTo(actual);
	}
}
