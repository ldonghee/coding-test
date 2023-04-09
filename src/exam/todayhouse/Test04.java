package exam.todayhouse;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Test04 {
	class Solution {
		public boolean solution(String[][] board, String word) {
			int m = board.length;
			int n = board[0].length;

			// board의 모든 좌표를 시작점으로 하지 않고,
			// word의 첫 글자와 일치하는 board의 좌표들만 시작점으로 한다.
			List<int[]> startPoints = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j].equals(String.valueOf(word.charAt(0)))) {
						startPoints.add(new int[]{i, j});
					}
				}
			}

			for (int[] startPoint : startPoints) {
				boolean[][] visited = new boolean[m][n];
				visited[startPoint[0]][startPoint[1]] = true;
				if (dfs(board, word, 1, startPoint[0], startPoint[1], visited)) {
					return true;
				}
			}

			return false;
		}

		private final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상, 우, 하, 좌

		private boolean dfs(String[][] board, String word, int index, int x, int y, boolean[][] visited) {
			if (index == word.length()) {
				return true;
			}

			for (int[] direction : DIRECTIONS) {
				int nextX = x + direction[0];
				int nextY = y + direction[1];
				if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length && !visited[nextX][nextY] && board[nextX][nextY].equals(String.valueOf(word.charAt(index)))) {
					visited[nextX][nextY] = true;
					if (dfs(board, word, index + 1, nextX, nextY, visited)) {
						return true;
					}
					visited[nextX][nextY] = false;
				}
			}

			return false;
		}

		/*
		public boolean solution(String[][] board, String word) {
			int m = board.length;
			int n = board[0].length;

			// 모든 셀을 시작점으로 해서 단어가 만들어지는지 검사
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j].equals(Character.toString(word.charAt(0)))) {
						if (dfs(board, word, i, j, 0)) {
							return true;
						}
					}
				}
			}
			return false;
		}

		// DFS 탐색 함수
		public boolean dfs(String[][] board, String word, int row, int col, int index) {
			int m = board.length;
			int n = board[0].length;

			// 탐색이 완료된 경우 true 반환
			if (index == word.length()) {
				return true;
			}

			// 격자 범위를 벗어난 경우 false 반환
			if (row < 0 || col < 0 || row >= m || col >= n) {
				return false;
			}

			// 현재 위치의 글자와 word[index]가 다른 경우 false 반환
			if (!board[row][col].equals(Character.toString(word.charAt(index)))) {
				return false;
			}

			// 현재 위치의 글자를 방문 처리
			String temp = board[row][col];
			board[row][col] = "#";

			// 8방향으로 dfs 탐색
			boolean result = dfs(board, word, row - 1, col, index + 1) || // 상
							 dfs(board, word, row + 1, col, index + 1) || // 하
							 dfs(board, word, row, col - 1, index + 1) || // 좌
							 dfs(board, word, row, col + 1, index + 1) || // 우
							 dfs(board, word, row - 1, col - 1, index + 1) || // 왼쪽 위 대각선
							 dfs(board, word, row - 1, col + 1, index + 1) || // 오른쪽 위 대각선
							 dfs(board, word, row + 1, col - 1, index + 1) || // 왼쪽 아래 대각선
							 dfs(board, word, row + 1, col + 1, index + 1); // 오른쪽 아래 대각선

			// 현재 위치의 글자를 방문 처리 취소
			board[row][col] = temp;

			return result;
		}
		*/
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		String[][] board = {{"O", "A", "C", "D", "E", "O"}, {"H", "O", "T", "C", "A", "P"}, {"P", "U", "S", "E", "T", "Z"}};
		String word = "OHOUSE";

		boolean expect = true;
		boolean actual = solution.solution(board, word);
		assertThat(actual).isEqualTo(expect);
	}
}
