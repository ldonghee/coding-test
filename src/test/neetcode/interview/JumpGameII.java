package test.neetcode.interview;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class JumpGameII {
	/**
	 * 제약 조건
	 * 1 <= nums.length <= 104
	 * 0 <= nums[i] <= 1000
	 * It's guaranteed that you can reach nums[n - 1].
	 *
	 *
	 *
	 * 엣지 케이스
	 */
	public int jump(int[] nums) {
		int count = 0, currMax = 0, nextMax = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			nextMax = Math.max(nextMax, i + nums[i]);

			if (i == currMax) {
				count++;
				currMax = nextMax;
			}
		}

		return count;
	}

	@Test
	public void test01() {
		int[] nums = {2,3,1,1,4};
		int expect = 2;
		int actual = jump(nums);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[] nums = {2,3,0,1,4};
		int expect = 2;
		int actual = jump(nums);
		assertThat(actual).isEqualTo(expect);
	}
}
