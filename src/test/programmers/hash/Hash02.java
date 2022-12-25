package test.programmers.hash;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/**
 * 폰켓몬
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 */
public class Hash02 {
	class Solution {
		public int solution(int[] nums) {
			int N = nums.length/2;
			Set<Integer> nSet = Arrays.stream(nums)
									  .boxed()
									  .collect(Collectors.toSet());

			return Integer.min(nSet.size(), N);
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[] nums = {3,1,2,3};

		int expect = 2;
		int actual = solution.solution(nums);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[] nums = {3,3,3,2,2,4};

		int expect = 3;
		int actual = solution.solution(nums);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		int[] nums = {3,3,3,2,2,2};

		int expect = 2;
		int actual = solution.solution(nums);
		assertThat(actual).isEqualTo(expect);
	}
}
