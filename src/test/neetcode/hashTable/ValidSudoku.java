package test.neetcode.hashTable;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 36. Valid Sudoku
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		return true;
	}

	@Test
	public void test() {
		char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
			, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
			, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
			, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
			, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
			, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
			, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
			, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
			, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		boolean actual = isValidSudoku(board);

		assertThat(actual).isEqualTo(true);
	}

	@Test
	public void test2() {
		char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
			, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
			, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
			, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
			, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
			, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
			, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
			, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
			, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		boolean actual = isValidSudoku(board);

		assertThat(actual).isEqualTo(false);
	}
}
