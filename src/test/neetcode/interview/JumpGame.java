package test.neetcode.interview;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class JumpGame {
	/**
	 * https://leetcode.com/problems/jump-game/
	 *
	 * 제약 조건
	 * 1 <= nums.length <= 104
	 * 0 <= nums[i] <= 105
	 *
	 *
	 * 시간 복잡도(Time Complexity): O(n^2)
	 * 이 알고리즘에서는 배열의 각 위치에서 가능한 모든 점프 위치를 탐색합니다.
	 * 최악의 경우, 각 위치에서 가능한 모든 점프 위치를 탐색해야 하므로 시간 복잡도는 O(n^2)가 됩니다.
	 *
	 * 공간 복잡도(Space Complexity): O(n)
	 * DP 배열은 입력 배열과 동일한 크기를 가지므로, 공간 복잡도는 O(n)입니다.
	 * 여기서 n은 입력 배열의 길이를 의미합니다.
	 *
	 *
	 * 엣지 케이스
	 * 배열의 길이가 1인 경우: 이 경우에는 이미 끝에 도달한 상태이므로 항상 true를 반환해야 합니다.
	 * 배열의 첫 번째 요소가 0인 경우: 이 경우에는 점프를 할 수 없으므로 항상 false를 반환해야 합니다. 단, 배열의 길이가 1인 경우는 제외입니다.
	 * 배열에 0이 포함된 경우: 이 경우에는 0 위치 이전의 요소 값이 0의 인덱스보다 커야만 끝까지 도달할 수 있습니다. 만약 그렇지 않다면 false를 반환해야 합니다.
	 * 배열의 모든 요소가 최대값인 경우: 이 경우에는 항상 true를 반환해야 합니다.
	 *
	 *
	 */
	public boolean canJump(int[] nums) {
		int n = nums.length;
		Boolean[] dp = new Boolean[n];
		return dfs(0, nums, dp);

	}

	public boolean dfs(int index, int[] nums, Boolean[] dp) {
		if (nums.length - 1 <= index) {
			return true;
		}

		if (dp[index] != null ){
			return dp[index];
		}

		int maxLength = nums[index];
		for (int i=1; i<= maxLength; i++) {
			boolean res = dfs(index + i, nums, dp);
			if (res) {
				dp[index] = true;
				return dp[index];
			}
		}
		return dp[index] = false;
	}



	@Test
	public void test01() {
		int[] nums = {2,3,1,1,4};
		boolean expect = true;
		boolean actual = canJump(nums);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[] nums = {3,2,1,0,4};
		boolean expect = false;
		boolean actual = canJump(nums);
		assertThat(actual).isEqualTo(expect);
	}
}
