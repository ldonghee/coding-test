package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {
	public int[] moveZeroes(int[] nums) {
		int[] answers = new int[nums.length];
		int left = 0;
		int right = nums.length - 1;
		int cur = 0;
		
		while (left <= right) {
			if (nums[cur] == 0) {
				answers[right] = 0;
				right -= 1;
			} else {
				answers[left] = nums[cur];
				left += 1;
			}
			cur += 1;
		}

		return answers;
	}

	void moveZeroes2(int[] nums) {
		int len = nums.length;
		int idx = 0;

		for(int i=0; i<len; i++){
			if(nums[i] != 0){
				nums[idx++] = nums[i];
			}
		}
		Arrays.fill(nums, idx, len, 0);
	}


	@Test
	void test1() {
		int nums[] = {0, 1, 0, 3, 12};
		int[] expect = {1, 3, 12, 0, 0};
		int[] actual = moveZeroes(nums);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	void test2() {
		int nums[] = {0};
		int[] expect = {0};
		int[] actual = moveZeroes(nums);
		assertThat(expect).isEqualTo(actual);
	}
}
