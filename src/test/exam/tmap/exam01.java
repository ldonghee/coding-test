package test.exam.tmap;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class exam01 {
	/**
	 * There is an array A that consisters of N integers.
	 * In one move you can select a number from A and replace it by the sum of its digits.
	 * One number can be selected multiple times.
	 * you can apply at most two moves.
	 * What is the minimum sum of the array you can ahcieve?
	 *
	 * that, given an array A , returns the mininum sum of the array you can achieve after applying at most two moves.
	 *
	 * For example,
	 *
	 * 1. Given A = [1, 10, 12, 3], you can apply the move one the second and third elements. Then A = [1, 1, 3, 3] and the function should return 8.
	 *
	 * 2. Given A = [2, 29, 3], you can apply the move one the second elements. Then A = [2, 2, 3] and the function should return 7.
	 *
	 * 3. Given A = [100, 101, 102, 103], you can apply the move one the first and second elements. Then A = [1, 2, 102, 103] and the function should return 208.
	 *
	 * 4. Given A = [55], you can apply the move one twice on the first elements. Then A = [1] and the function should return 1.
	 *
	 * Write an efficient algorithm for the following assumptions:
	 *
	 * N is an integer within the range [1..50,000];
	 * each element of array A is an integer within the range [1..10,000].
	 *
	 *
	 */
	class Solution {
		public int solution(int[] A) {
			int moves = 2;

			while (moves > 0) {
				int maxIndex = -1;
				int maxSum = -1;

				for (int i = 0; i < A.length; i++) {
					int digitSum = funcSum(A[i]);
					if (A[i] > digitSum && digitSum > maxSum) {
						maxIndex = i;
						maxSum = digitSum;
					}
				}

				if (maxIndex != -1) {
					A[maxIndex] = maxSum;
					moves--;
					continue;
				}

				break;
			}

			return Arrays.stream(A).sum();
		}

		public int funcSum(int n) {
			int sum = 0;
			while (n > 0) {
				sum += n % 10;
				n /= 10;
			}
			return sum;
		}
	}

	private final Solution solution = new Solution();


	@Test
	public void test1() {
		int[] A = {1, 10, 12, 3};

		int expect = 8;
		int actual = solution.solution(A);

		assertThat(actual).isEqualTo(expect);
	}


	@Test
	public void test2() {
		int[] A = {2, 29, 3};

		int expect = 7;
		int actual = solution.solution(A);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test3() {
		int[] A = {100, 101, 102, 103};

		int expect = 208;
		int actual = solution.solution(A);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test4() {
		int[] A = {55};

		int expect = 1;
		int actual = solution.solution(A);

		assertThat(actual).isEqualTo(expect);
	}
}