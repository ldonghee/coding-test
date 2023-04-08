package test.neetcode.backtracking;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search/
 * https://neetcode.io/roadmap
 */
public class WordSearch {
	class Solution {
		public boolean exist(char[][] board, String word) {
			int rows = board.length;
			int cols = board[0].length;
			boolean[][] visited = new boolean[rows][cols];

			// 주어진 보드의 모든 셀에 대해 시작
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (board[i][j] == word.charAt(0) && backtrack(board, word, visited, i, j, 0)) {
						return true;
					}
				}
			}
			return false;
		}

		private boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
			// 단어의 모든 문자를 찾았을 경우 true를 반환합니다.
			if (index == word.length()) {
				return true;
			}

			// 보드의 경계를 벗어난 경우, 이미 방문한 셀인 경우, 현재 셀의 문자가 단어의 문자와 일치하지 않는 경우, false를 반환합니다.
			if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
				return false;
			}

			// 현재 셀을 방문했음을 표시합니다.
			visited[i][j] = true;

			// 현재 셀에서 상하좌우로 이동하여 다음 문자를 찾습니다.
			boolean result = backtrack(board, word, visited, i - 1, j, index + 1)
							 || backtrack(board, word, visited, i + 1, j, index + 1)
							 || backtrack(board, word, visited, i, j - 1, index + 1)
							 || backtrack(board, word, visited, i, j + 1, index + 1);

			// backtracking을 수행합니다.
			visited[i][j] = false;

			return result;
		}


		/*

		public boolean exist(char[][] board, String word) {
			if (board == null || board.length == 0 || board[0].length == 0) {
				return false;
			}
			int m = board.length;
			int n = board[0].length;
			boolean[][] visited = new boolean[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (dfs(board, visited, i, j, word, 0)) {
						return true;
					}
				}
			}
			return false;
		}

		private boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int index) {
			if (index == word.length()) {
				return true;
			}
			if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
				|| visited[i][j] || board[i][j] != word.charAt(index)) {
				return false;
			}
			visited[i][j] = true;
			boolean res = dfs(board, visited, i + 1, j, word, index + 1)
						  || dfs(board, visited, i - 1, j, word, index + 1)
						  || dfs(board, visited, i, j + 1, word, index + 1)
						  || dfs(board, visited, i, j - 1, word, index + 1);
			visited[i][j] = false;
			return res;
		}

		*/
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";

		boolean expect = true;
		boolean actual = solution.exist(board, word);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "SEE";

		boolean expect = true;
		boolean actual = solution.exist(board, word);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCB";

		boolean expect = false;
		boolean actual = solution.exist(board, word);
		assertThat(actual).isEqualTo(expect);
	}
}
