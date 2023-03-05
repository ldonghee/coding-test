package test.neetcode.binarySearch;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/
 * https://neetcode.io/roadmap
 */
public class SearchA2DMatrix {
	class Solution {
		public boolean searchMatrix(int[][] matrix, int target) {

			for (int i=0; i<matrix.length; i++) {
				if (matrix[i][0] <= target) {
					int[] row = matrix[i];

					for (int j=0; j<row.length; j++) {
						if (target == row[j]) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 3;

		boolean expect = true;
		boolean actual = solution.searchMatrix(matrix, target);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[][] matrix = {{1,3,5,7},{10,11,16,20}, {23,30,34,60}};
		int target = 13;

		boolean expect = false;
		boolean actual = solution.searchMatrix(matrix, target);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		int[][] matrix = {{1}};
		int target = 0;

		boolean expect = false;
		boolean actual = solution.searchMatrix(matrix, target);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test04() {
		int[][] matrix = {{1}, {3}};
		int target = 0;

		boolean expect = false;
		boolean actual = solution.searchMatrix(matrix, target);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test05() {
		int[][] matrix = {{1}};
		int target = 1;

		boolean expect = true;
		boolean actual = solution.searchMatrix(matrix, target);
		assertThat(actual).isEqualTo(expect);
	}

}
