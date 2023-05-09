package exam.todayhouse.study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 1572. Matrix Diagonal Sum
 * https://leetcode.com/problems/matrix-diagonal-sum/
 */
public class MatrixDiagonalSum {
	class Solution {
		public int diagonalSum(int[][] mat) {
			int sum = 0;
			for (int i=0; i<mat.length; i++) {
				sum += mat[i][i];
				if (i != (mat.length - 1 - i))
					sum += mat[i][mat.length - 1 - i];
			}

			return sum;
		}
	}

	private Solution solution = new Solution();

	@Test
	public void test01() {
		int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};

		int expect = 25;
		int actual = solution.diagonalSum(mat);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[][] mat = {{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}};

		int expect = 8;
		int actual = solution.diagonalSum(mat);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		int[][] mat = {{5}};

		int expect = 5;
		int actual = solution.diagonalSum(mat);
		assertThat(actual).isEqualTo(expect);
	}
}
